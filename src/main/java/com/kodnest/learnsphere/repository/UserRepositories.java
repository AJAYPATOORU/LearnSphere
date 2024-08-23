package com.kodnest.learnsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.learnsphere.entity.Users;

public interface UserRepositories extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);
	boolean existsByEmail(String email);
	
}
