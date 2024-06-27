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
	
	public User insert( User user ) {
		return userRepository.save( user );
	}
	
	public void delete( Integer id ) {
		userRepository.deleteById( id );
	}
	
	public User update( Integer id, User obj ) {
		User user = userRepository.getReferenceById( id );
		updateData( user, obj );
		return userRepository.save( user );
	}
	
	public void updateData( User user, User obj ) {
		user.setName(  obj.getName() );
		user.setEmail( obj.getEmail() );
		user.setPhone( obj.getPhone() );
	}
}
