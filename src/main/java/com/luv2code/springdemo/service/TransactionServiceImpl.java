package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.TransactionDAO;
import com.luv2code.springdemo.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Override
	@Transactional
	public List<Transaction> getTransactions() {
		return transactionDAO.getTransactions();
	}

	@Override
	@Transactional
	public void saveTransaction(Transaction theTransaction) {
		transactionDAO.saveTransaction(theTransaction);
	}

	@Override
	@Transactional
	public Transaction getTransaction(int theId) {
		return transactionDAO.getTransaction(theId);
	}

	@Override
	@Transactional
	public void deleteTransaction(int theId) {
		transactionDAO.deleteTransaction(theId);
	}

}
