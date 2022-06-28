package com.shyam.angular.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.angular.springboot.model.DatabaseFile;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {
	
	DatabaseFile findByFileName(String fileName);

}
