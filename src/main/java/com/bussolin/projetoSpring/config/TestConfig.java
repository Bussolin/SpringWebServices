package com.bussolin.projetoSpring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bussolin.projetoSpring.entities.User;
import com.bussolin.projetoSpring.repositories.UserRepository;

@Configuration
@Profile( "test" )
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "LuisSpring","Spring@gmail.com","44997912392","123");
		User u2 = new User(null, "LuisBoot","boot@gmail.com","44997912392","123");
		
		userRepository.saveAll( Arrays.asList(u1,u2) );
	}
	
	
}
