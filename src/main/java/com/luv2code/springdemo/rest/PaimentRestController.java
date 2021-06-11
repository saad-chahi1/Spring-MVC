package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Payment;
import com.luv2code.springdemo.service.PaimentService;

@RestController
@RequestMapping("/api")
public class PaimentRestController {

	// autowire the CustomerService
	@Autowired
	private PaimentService paimentService;
	
	// add mapping for POST /customers  - add new customer	
	@GetMapping("/paiment")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Payment> Paiments() {
		
		return paimentService.getPaiments();
	}

	// add mapping for POST /customers  - add new customer	
	@PostMapping("/paiments")
	@CrossOrigin(origins = "http://localhost:4200")
	public Payment addCustomer(@RequestBody Payment theCustomer) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theCustomer.setId_payment(0);
		
		paimentService.savePayment(theCustomer);
		
		return theCustomer;
	}
	
		
	
}