package com.bussolin.projetoSpring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.bussolin.projetoSpring.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant orderMoment;
	
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_ordcli") )
	private User client;

	@OneToMany( mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne( mappedBy = "order", cascade = CascadeType.ALL )
	private Payment payment;
	
	public Order() {
	}
	
	public Order(Integer id, Instant orderMoment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.orderMoment = orderMoment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getOrderMoment() {
		return orderMoment;
	}

	public void setOrderMoment(Instant orderMoment) {
		this.orderMoment = orderMoment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf( orderStatus );
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if( orderStatus != null ) {
			this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Set<OrderItem> getItems(){
		return items;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Double getTotal() {
		Double total = 0D;
		for( OrderItem oi : items ) {
			total += oi.getSubTotal();
		}
		return total;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
