package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springdemo.entity.Transaction;
import com.luv2code.springdemo.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionRestController {
	
	// autowire the CustomerService
	@Autowired
	private TransactionService transactionService;
	
	// add mapping for GET /customers
	@GetMapping("/transactions")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Transaction> getTransactions() {
		return transactionService.getTransactions();
		
	}
	
	// add mapping for GET /customers
	@GetMapping("/transactions/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Transaction getTransactions(@PathVariable int id) {
		Transaction cs = transactionService.getTransaction(id);
		if(cs==null) {
			throw new ClientNotFoundException("Transaction id not Found : "+id);
		}
		return cs;
		
	}
}
