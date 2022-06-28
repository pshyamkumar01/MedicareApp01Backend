package com.shyam.angular.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.angular.springboot.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	Cart findByName(String name);
	
}
