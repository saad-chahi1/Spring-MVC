package com.luv2code.springdemo.rest;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.AuthenticationBean;

@CrossOrigin(origins = "http://localhost:4200")	
@RestController
public class LoginController {

	@CrossOrigin(origins = "http://localhost:4200")	
	@GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }
}
