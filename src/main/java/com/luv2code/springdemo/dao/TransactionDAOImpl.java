package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Compte;
import com.luv2code.springdemo.entity.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Transaction> getTransactions() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query query = currentSession.createQuery("from Transaction");
		List<Transaction> list = query.list();	
		// return the results		
		return list;
	}

	@Override
	public void saveTransaction(Transaction theTransaction) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theTransaction);
		
	}

	@Override
	public Transaction getTransaction(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Transaction theTransaction = currentSession.get(Transaction.class, theId);
		
		return theTransaction;
	}

	@Override
	public void deleteTransaction(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from transaction where id_transaction=:id_transaction");
		theQuery.setParameter("id_transaction", theId);
		
		theQuery.executeUpdate();
	}

}
