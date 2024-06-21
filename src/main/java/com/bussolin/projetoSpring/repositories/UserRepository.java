package com.bussolin.projetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussolin.projetoSpring.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
