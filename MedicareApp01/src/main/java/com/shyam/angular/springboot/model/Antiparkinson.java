package com.shyam.angular.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Antiparkinson {

	private long id;
	private String name;
	private String description;
	private String price;
	
	public Antiparkinson() {
		super();
	}

	public Antiparkinson(long id, String name, String description, String price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
