package com.shyam.angular.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.angular.springboot.Repository.AnalgesicsRepository;
import com.shyam.angular.springboot.exception.ResourceNotFoundException;
import com.shyam.angular.springboot.model.Analgesics;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

	@Autowired
	private AnalgesicsRepository analgesicsRepository;
	
	@GetMapping("/get-analgesics-list")
	public List<Analgesics> analgesicsList()
	{
		return analgesicsRepository.findAll();
	}
	
	@PostMapping("/add-new-item")
	public Analgesics addNewItem(@RequestBody Analgesics analgesics)
	{
		return analgesicsRepository.save(analgesics);
	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/get-item-by-name/{name}")
//	public ResponseEntity<Analgesics> getItemByName(@PathVariable String name)
//	{
//		System.out.println("The Item name is :"+ name);
//		Analgesics employee = analgesicsRepository.findByName(name)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not Exists by Id: "+ id));
//		return ResponseEntity.ok(employee);
//		 
//	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get-item-by/{id}")
	public ResponseEntity<Analgesics> getEmployeeById(@PathVariable long id)
	{
		Analgesics analg = analgesicsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("medicine not Exists by Id: "+ id));
		
		System.out.println("The description is :"+ analg.getDescription());
		return ResponseEntity.ok(analg);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateItem/{id}")
	public ResponseEntity<Analgesics> updateEmployee(@PathVariable long id, @RequestBody Analgesics existingItemDetails)
	{
		Analgesics analUpdate = analgesicsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not Exists by Id: "+ id));
		
		analUpdate.setName(existingItemDetails.getName());
		analUpdate.setPrice(existingItemDetails.getPrice());
		analUpdate.setDescription(existingItemDetails.getDescription());
		
		Analgesics updatedItemDetails = analgesicsRepository.save(analUpdate);
		
		return ResponseEntity.ok(updatedItemDetails);
		
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete-item/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable long id)
	{
		Analgesics analg = analgesicsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product does not Exists by Id: "+ id));
		
		analgesicsRepository.delete(analg);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
}
