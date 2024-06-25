package com.bussolin.projetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bussolin.projetoSpring.entities.Category;
import com.bussolin.projetoSpring.services.CategoryService;

@RestController
@RequestMapping( value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> categorys = service.findAll();
		return ResponseEntity.ok().body( categorys );
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id ){
		Category category = service.findById( id );
		return ResponseEntity.ok().body( category );
	}
}
