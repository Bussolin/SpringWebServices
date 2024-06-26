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

import com.bussolin.projetoSpring.entities.Product;
import com.bussolin.projetoSpring.services.ProductService;

@RestController
@RequestMapping( value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = service.findAll();
		return ResponseEntity.ok().body( products );
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id ){
		Product product = service.findById( id );
		return ResponseEntity.ok().body( product );
	}
	
	@PostMapping
	public ResponseEntity<Product> insert( @RequestBody Product product ){
		product = service.insert(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created( uri ).body(product);
	}
	
	@DeleteMapping( value = "/{id}" )
	@ResponseStatus( value = HttpStatus.NO_CONTENT )
	public void delete( @PathVariable Integer id ){
		service.delete( id );
	}
	
	@PutMapping( value = "/{id}" )
	public ResponseEntity<Product> update( @PathVariable Integer id, @RequestBody Product obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
