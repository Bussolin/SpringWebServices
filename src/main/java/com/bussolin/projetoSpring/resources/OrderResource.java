package com.bussolin.projetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bussolin.projetoSpring.entities.Order;
import com.bussolin.projetoSpring.services.OrderService;

@RestController
@RequestMapping( value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> orders = service.findAll();
		return ResponseEntity.ok().body( orders );
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id ){
		Order order = service.findById( id );
		return ResponseEntity.ok().body( order );
	}
}
