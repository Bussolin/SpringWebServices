package com.bussolin.projetoSpring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bussolin.projetoSpring.entities.User;

@RestController
@RequestMapping( value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1, "Luis", "luis@gmail.com","44919231923","123");
		return ResponseEntity.ok().body(u);
	}
}
