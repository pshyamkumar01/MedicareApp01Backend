package com.shyam.angular.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.angular.springboot.Repository.CartRepository;
import com.shyam.angular.springboot.model.Cart;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

	@Autowired
	private CartRepository cartRepository;
	int total = 0;
	
	@PostMapping("/add-to-cart")
	public Cart addToCart(@RequestBody Cart cart)
	{
		int price =0;
		price = cart.getPrice();
		int net = price;
		total = total+net;
		
		cart.setTotal(total);
		System.out.println("The total Price is:"+ total);
		return cartRepository.save(cart);
		
	}

}
