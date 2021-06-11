package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Payment;
import com.luv2code.springdemo.entity.Transaction;
import com.luv2code.springdemo.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionRestController {
	
	// autowire the CustomerService
	@Autowired
	private TransactionService transactionService;
	
	// add mapping for GET /customers
	@GetMapping("/lastTransactions/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Transaction> getTransaction(@PathVariable int id) {
		return transactionService.getTransactions(id);
		
	}
	
	@PostMapping("/transactions")
	@CrossOrigin(origins = "http://localhost:4200")
	public Transaction addCustomer(@RequestBody Transaction theCustomer) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theCustomer.setId_transaction(0);
		
		transactionService.saveTransaction(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for GET /customers
	@GetMapping("/transaction/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Transaction getTransactions(@PathVariable int id) {
		Transaction cs = transactionService.getLastTransaction(id);		
		return cs;
		
	}
}
