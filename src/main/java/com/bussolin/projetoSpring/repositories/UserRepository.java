package com.bussolin.projetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bussolin.projetoSpring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
