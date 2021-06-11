package com.luv2code.springdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	// autowire the CustomerService
	@Autowired
	private UserService userService;
	
	// add mapping for GET /customers
	@GetMapping("/users/id")
	@CrossOrigin(origins = "http://localhost:4200")
	public int getUsers(@RequestParam(value = "_search") String search) {
		
		User cs = userService.getUser(search);
		if(cs==null) {
			throw new ClientNotFoundException("User id not Found : "+search);
		}
		return cs.getId_client();
		
	}

}
