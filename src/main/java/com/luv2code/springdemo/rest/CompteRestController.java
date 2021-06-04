package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springdemo.entity.Compte;
import com.luv2code.springdemo.service.CompteService;

@RestController
@RequestMapping("/api")
public class CompteRestController {
	// autowire the CustomerService
	@Autowired
	private CompteService compteService;
	
	// add mapping for GET /customers
	@GetMapping("/comptes")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Compte> getComptes() {
		return compteService.getComptes();
		
	}
	
	// add mapping for GET /customers
	@GetMapping("/comptes/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Compte getComptes(@PathVariable int id) {
		Compte cs = compteService.getCompte(id);
		if(cs==null) {
			throw new ClientNotFoundException("Compte id not Found : "+id);
		}
		return cs;
		
	}
}
