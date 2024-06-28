package com.bussolin.projetoSpring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Category> insert( @RequestBody Category category ){
		category = service.insert(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created( uri ).body(category);
	}
	
	@DeleteMapping( value = "/{id}" )
	@ResponseStatus( value = HttpStatus.NO_CONTENT )
	public void delete( @PathVariable Integer id ){
		service.delete( id );
	}
	
	@PutMapping( value = "/{id}" )
	public ResponseEntity<Category> update( @PathVariable Integer id, @RequestBody Category obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
