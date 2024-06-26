package com.bussolin.projetoSpring.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bussolin.projetoSpring.entities.Category;
import com.bussolin.projetoSpring.entities.Order;
import com.bussolin.projetoSpring.entities.OrderItem;
import com.bussolin.projetoSpring.entities.Payment;
import com.bussolin.projetoSpring.entities.Product;
import com.bussolin.projetoSpring.entities.User;
import com.bussolin.projetoSpring.entities.enums.OrderStatus;
import com.bussolin.projetoSpring.repositories.CategoryRepository;
import com.bussolin.projetoSpring.repositories.OrderItemRepository;
import com.bussolin.projetoSpring.repositories.OrderRepository;
import com.bussolin.projetoSpring.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "LuisSpring","Spring@gmail.com","44997912392","123");
		User u2 = new User(null, "LuisBoot","boot@gmail.com","44997912392","123");
		
		Order o1 = new Order(null, Instant.now(), OrderStatus.SHIPPED, u1);
		Order o2 = new Order(null, Instant.now(), OrderStatus.DELLIVERED ,u2 );

		Category c1 = new Category( null, "Category 1");
		Category c2 = new Category( null, "Category 2");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		categoryRepository.saveAll( Arrays.asList(c1,c2) );
		userRepository.saveAll( Arrays.asList(u1,u2) );
		orderRepository.saveAll( Arrays.asList(o1,o2) );
		
		
		p1.getCategories().add(c1);
		p2.getCategories().add(c1);
		p2.getCategories().add(c2);
		p3.getCategories().add(c1);
		p4.getCategories().add(c2);
		p5.getCategories().add(c1);
		
		
		
		productRepository.saveAll( Arrays.asList( p1,p2, p3, p4, p5 ) );
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
	
		orderItemRepository.saveAll( Arrays.asList( oi1,oi2,oi3));
		
		Payment pay = new Payment( null,Instant.now().plus( 4L, ChronoUnit.HOURS ), o1 );
		o1.setPayment(pay);
		orderRepository.save(o1);
	}
	
	
}
