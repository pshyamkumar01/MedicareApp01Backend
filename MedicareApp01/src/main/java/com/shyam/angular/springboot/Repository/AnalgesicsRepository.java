package com.shyam.angular.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.angular.springboot.model.Analgesics;

public interface AnalgesicsRepository extends JpaRepository<Analgesics, Long> {

	Analgesics findByName(String name);
}
