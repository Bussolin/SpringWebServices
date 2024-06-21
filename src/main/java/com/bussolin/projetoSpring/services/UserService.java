package com.bussolin.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bussolin.projetoSpring.entities.User;
import com.bussolin.projetoSpring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById( Integer id ) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	
}
