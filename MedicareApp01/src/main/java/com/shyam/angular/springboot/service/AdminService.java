package com.shyam.angular.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shyam.angular.springboot.Repository.AdminRepository;
import com.shyam.angular.springboot.Repository.UserRepository;
import com.shyam.angular.springboot.model.Admin;
import com.shyam.angular.springboot.model.User;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public Admin getadminEmailandPassword(String email, String password)
	{
		return adminRepository.findByEmailAndPassword(email, password);
	}
}
