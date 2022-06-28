package com.shyam.angular.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.angular.springboot.model.User;
import com.shyam.angular.springboot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/user")
	public String welcome()
	{
		return "welcome user.......";
	}
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerNewUser(@RequestBody User user) throws Exception
	{
		String tempemail1 = user.getEmail();
		if(tempemail1 != null && !"".equals(tempemail1))
		{
			User tempemail2 = userService.getUserByEmail(tempemail1);
			if(tempemail2 != null)
			{
				throw new Exception("Use with email "+tempemail1+" Already Existed");
			}
		}
		User obj = null;
		obj = userService.registerUser(user);
		return obj;
	}
	
	@PostMapping("/loginuser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempemail = user.getEmail();
		String temppassword = user.getPassword();
		User obj = null;
		if(tempemail != null && temppassword != null)
		{
			obj = userService.getUserByEmailandPassword(tempemail, temppassword);
		}
			
			if(obj == null)
			{
				throw new Exception("User Email or Password is Incorrect");
			}
		
		return obj;
	}	
}
