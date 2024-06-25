package com.bussolin.projetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bussolin.projetoSpring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
