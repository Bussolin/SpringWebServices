package com.bussolin.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bussolin.projetoSpring.entities.Order;
import com.bussolin.projetoSpring.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById( Integer id ) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}
	
}
