package com.luv2code.springdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Agence;
import com.luv2code.springdemo.service.AgenceService;

@RestController
@RequestMapping("/api")
public class AgenceController {
	

	// autowire the CustomerService
	@Autowired
	private AgenceService agenceService;
	
	// add mapping for GET /customers
	@GetMapping("/agences/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Agence getAgence(@PathVariable int id) {
		
		Agence cs = agenceService.getAgence(id);
		if(cs==null) {
			throw new ClientNotFoundException("Agence id not Found : "+id);
		}
		return cs;
		
	}
		

}
