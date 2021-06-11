package com.luv2code.springdemo.service;

import java.util.List;


import com.luv2code.springdemo.entity.Transaction;

public interface TransactionService {
	public List<Transaction> getTransactions(int theId);

	public void saveTransaction(Transaction theTransaction);

	public Transaction getLastTransaction(int id);

	public void deleteTransaction(int theId);
}
