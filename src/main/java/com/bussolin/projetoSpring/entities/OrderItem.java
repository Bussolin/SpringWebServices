package com.bussolin.projetoSpring.entities;

import java.io.Serializable;
import java.util.Objects;

import com.bussolin.projetoSpring.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id;
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}
	
	public OrderItem(Order id, Product product ,Integer quantity, Double price) {
		super();
		this.id.setOrder(id);
		this.id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct( Product product) {
		id.setProduct(product);
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder( Order order) {
		id.setOrder(order);
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}
