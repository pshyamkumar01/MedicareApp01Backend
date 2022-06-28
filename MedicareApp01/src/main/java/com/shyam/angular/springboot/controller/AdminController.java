package com.shyam.angular.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.angular.springboot.model.Admin;
import com.shyam.angular.springboot.model.User;
import com.shyam.angular.springboot.service.AdminService;
import com.shyam.angular.springboot.service.UserService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public String welcome()
	{
		return "welcome amdin.......";
	}
	
	@PostMapping("/adminlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public Admin getEmailandPassword(@RequestBody Admin admin) throws Exception
	{
		String adminemail = admin.getEmail();
		String adminpassword = admin.getPassword();
		Admin obj = null;
		if(adminemail != null && adminpassword != null)
		{
			obj = adminService.getadminEmailandPassword(adminemail, adminpassword);
			if(obj == null)
			{
				throw new Exception("Admin eamil or Password is Incorrect");
			}
		}
		return obj;
	}
	
}
