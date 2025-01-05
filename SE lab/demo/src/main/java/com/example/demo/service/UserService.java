package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	List<User> getAllUsers();
	void saveUser(User User);
	User getUserById(Long id);
	void deleteUserById(Long id);
}
 