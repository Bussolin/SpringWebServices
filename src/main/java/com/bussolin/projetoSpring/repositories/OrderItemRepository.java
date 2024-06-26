package com.bussolin.projetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussolin.projetoSpring.entities.OrderItem;
import com.bussolin.projetoSpring.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
