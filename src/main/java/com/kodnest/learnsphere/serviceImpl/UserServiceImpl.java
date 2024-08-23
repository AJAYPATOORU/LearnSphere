package com.kodnest.learnsphere.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.learnsphere.entity.Users;
import com.kodnest.learnsphere.repository.UserRepositories;
import com.kodnest.learnsphere.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	 UserRepositories repo;
	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User added";
	}
	@Override
	public Users findUserByEmail(String email) {

		return repo.findByEmail(email);
	}
	@Override
	public boolean chechEmail(String email) {

		return repo.existsByEmail(email);
	}
	@Override
	public String saveUsers(Users user) {
repo.save(user);
return "users updated";
	}


	
}
