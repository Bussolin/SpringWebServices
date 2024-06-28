package com.bussolin.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bussolin.projetoSpring.entities.Product;
import com.bussolin.projetoSpring.entities.Product;
import com.bussolin.projetoSpring.repositories.ProductRepository;
import com.bussolin.projetoSpring.services.exceptions.DataBaseException;
import com.bussolin.projetoSpring.services.exceptions.NoContentException;
import com.bussolin.projetoSpring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> validateList = productRepository.findAll();
		if (validateList.isEmpty()) {
			throw new NoContentException("No content found");
		}
		return validateList;
	}

	public Product findById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Product insert(Product product) {
		return productRepository.save(product);
	}

	public void delete(Integer id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Product update(Integer id, Product obj) {
		try {
			Product product = productRepository.getReferenceById(id);
			updateData(product, obj);
			return productRepository.save(product);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Product product, Product obj) {
		product.setName(obj.getName());
		product.setDescription(obj.getDescription());
		product.setPrice(obj.getPrice());
		product.setImgUrl(obj.getImgUrl());
	}
}
