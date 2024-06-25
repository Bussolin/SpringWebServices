package com.bussolin.projetoSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bussolin.projetoSpring.entities.Category;
import com.bussolin.projetoSpring.entities.Order;
import com.bussolin.projetoSpring.entities.User;
import com.bussolin.projetoSpring.entities.enums.OrderStatus;
import com.bussolin.projetoSpring.repositories.CategoryRepository;
import com.bussolin.projetoSpring.repositories.OrderRepository;
import com.bussolin.projetoSpring.repositories.UserRepository;

@Configuration
@Profile( "test" )
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "LuisSpring","Spring@gmail.com","44997912392","123");
		User u2 = new User(null, "LuisBoot","boot@gmail.com","44997912392","123");
		
		Order o1 = new Order(null, Instant.now(), OrderStatus.SHIPPED, u1);
		Order o2 = new Order(null, Instant.now(), OrderStatus.DELLIVERED ,u2 );

		Category c1 = new Category( null, "Category 1");
		Category c2 = new Category( null, "Category 2");
		
		
		userRepository.saveAll( Arrays.asList(u1,u2) );
		orderRepository.saveAll( Arrays.asList(o1,o2) );
		categoryRepository.saveAll( Arrays.asList(c1,c2) );
		
	}
	
	
}
