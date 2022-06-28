package com.shyam.angular.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.angular.springboot.model.CartOrder;

public interface CartOrderRepository extends JpaRepository<CartOrder, Long> {

}
