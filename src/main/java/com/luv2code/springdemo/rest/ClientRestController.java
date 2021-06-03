package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Client;
import com.luv2code.springdemo.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientRestController {

	// autowire the CustomerService
	@Autowired
	private ClientService clientService;
	
	// add mapping for GET /customers
	@GetMapping("/clients")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<?> getClients() {
		return clientService.getClients();
		
	}
	
	// add mapping for GET /customers
	@GetMapping("/clients/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Client getClients(@PathVariable int id) {
		Client cs = clientService.getClient(id);
		if(cs==null) {
			throw new ClientNotFoundException("Client id not Found : "+id);
		}
		return cs;
		
	}
		
	
}


















