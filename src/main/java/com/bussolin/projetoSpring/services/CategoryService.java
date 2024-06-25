package com.bussolin.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bussolin.projetoSpring.entities.Category;
import com.bussolin.projetoSpring.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository CategoryRepository;
	
	@GetMapping
	public List<Category> findAll(){
		return CategoryRepository.findAll();
	}
	
	public Category findById( Integer id ) {
		Optional<Category> Category = CategoryRepository.findById(id);
		return Category.get();
	}
	
}
