package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Transaction;

public interface TransactionDAO {
	
	public List<Transaction> getTransactions();

	public void saveTransaction(Transaction theTransaction);

	public Transaction getTransaction(int theId);

	public void deleteTransaction(int theId);
}
