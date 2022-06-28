package com.shyam.angular.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.angular.springboot.Repository.CartOrderRepository;
import com.shyam.angular.springboot.model.CartOrder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartOrderController {

	@Autowired
	private CartOrderRepository cartOrderRepository;
	
	@PostMapping("/createCartOrder")
	public CartOrder createCartOrder(@RequestBody CartOrder cartOrder)
	{
		return cartOrderRepository.save(cartOrder);
	}
}
