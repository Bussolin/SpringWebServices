package com.bussolin.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bussolin.projetoSpring.entities.Product;
import com.bussolin.projetoSpring.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository ProductRepository;
	
	@GetMapping
	public List<Product> findAll(){
		return ProductRepository.findAll();
	}
	
	public Product findById( Integer id ) {
		Optional<Product> product = ProductRepository.findById(id);
		return product.get();
	}
	
}
