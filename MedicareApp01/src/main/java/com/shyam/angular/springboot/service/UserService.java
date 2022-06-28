package com.shyam.angular.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shyam.angular.springboot.Repository.UserRepository;
import com.shyam.angular.springboot.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user)
	{
		return userRepository.save(user);
	}
	
	public User getUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	public User getUserByEmailandPassword(String email, String password)
	{
		return userRepository.findByEmailAndPassword(email, password);
	}

}
