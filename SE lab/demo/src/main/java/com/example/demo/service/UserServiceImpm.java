package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpm implements UserService{
	
	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public List<User> getAllUsers() {
		return UserRepository.findAll();
	}

	@Override
	public void saveUser(User User) {
		this.UserRepository.save(User);
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> optional = UserRepository.findById(id);
		User User = null;
		if(optional.isPresent()) {
			User = optional.get();
		}
		else {
			throw new RuntimeException(" User Not Found for Id : " + id);
		}
		return User;
	}

	@Override
	public void deleteUserById(Long id) {
		this.UserRepository.deleteById(id);
	}
}