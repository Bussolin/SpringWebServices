package com.bussolin.projetoSpring.resources;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.bussolin.projetoSpring.entities.User;
import com.bussolin.projetoSpring.services.UserService;

@RestController
@RequestMapping( value = "/users" )
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users = service.findAll();
		return ResponseEntity.ok().body( users );
	}
	
	@GetMapping( value = "/{id}" )
	public ResponseEntity<User> findById(@PathVariable Integer id ){
		User user = service.findById( id );
		return ResponseEntity.ok().body( user );
	}
	
	@PostMapping
	public ResponseEntity<User> insert( @RequestBody User user ){
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created( uri ).body(user);
	}
	
	@DeleteMapping( value = "/{id}" )
	@ResponseStatus( value = HttpStatus.NO_CONTENT )
	public void delete( @PathVariable Integer id ){
		service.delete( id );
	}
	
	@PutMapping( value = "/{id}" )
	public ResponseEntity<User> update( @PathVariable Integer id, @RequestBody User obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
