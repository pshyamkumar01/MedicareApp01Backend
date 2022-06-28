package com.shyam.angular.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.angular.springboot.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmailAndPassword(String email, String password);
}
