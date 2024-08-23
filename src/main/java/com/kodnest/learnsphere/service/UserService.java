package com.kodnest.learnsphere.service;

import com.kodnest.learnsphere.entity.Users;

public interface UserService {

	String addUser(Users user);
	Users findUserByEmail(String email);
	
	boolean chechEmail(String email);

	String saveUsers(Users user);
	
}
