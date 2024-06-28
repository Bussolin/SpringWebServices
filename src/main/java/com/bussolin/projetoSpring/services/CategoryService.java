package com.bussolin.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bussolin.projetoSpring.entities.Category;
import com.bussolin.projetoSpring.repositories.CategoryRepository;
import com.bussolin.projetoSpring.services.exceptions.DataBaseException;
import com.bussolin.projetoSpring.services.exceptions.NoContentException;
import com.bussolin.projetoSpring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		List<Category> validateList = categoryRepository.findAll();
		if (validateList.isEmpty()) {
			throw new NoContentException("No content found");
		}
		return validateList;
	}
	
	public Category findById( Integer id ) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category insert(Category category) {
		return categoryRepository.save(category);
	}

	public void delete(Integer id) {
		try {
			categoryRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Category update(Integer id, Category obj) {
		try {
			Category category = categoryRepository.getReferenceById(id);
			updateData(category, obj);
			return categoryRepository.save(category);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Category category, Category obj) {
		category.setName(obj.getName());
	}
}