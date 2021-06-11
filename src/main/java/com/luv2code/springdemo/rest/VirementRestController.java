package com.luv2code.springdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Payment;
import com.luv2code.springdemo.entity.Virement;
import com.luv2code.springdemo.service.PaimentService;
import com.luv2code.springdemo.service.VirementService;

@RestController
@RequestMapping("/api")
public class VirementRestController {
	// autowire the CustomerService
	@Autowired
	private VirementService paimentService;
	
	@PostMapping("/virements")
	@CrossOrigin(origins = "http://localhost:4200")
	public Virement addCustomer(@RequestBody Virement theCustomer) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theCustomer.setId_virement(0);
		
		paimentService.saveVirement(theCustomer);
		
		return theCustomer;
	}
}
