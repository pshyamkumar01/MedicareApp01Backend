package com.shyam.angular.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.angular.springboot.model.Hormonal;

public interface HormonalRepository extends JpaRepository<Hormonal, Long> {

}
