package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Client;
import com.luv2code.springdemo.entity.Compte;

@Repository
public class ClientDAOImpl implements ClientDAO{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> getClients() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query query = 
				currentSession.createQuery("from Client");
		List<?> list = query.list();
		
				
		// return the results		
		return list;
	}

	@Override
	public void saveClient(Client theClient) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theClient);
	}

	@Override
	public Client getClient(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Client theClient = currentSession.get(Client.class, theId);
		
		return theClient;
	}

	@Override
	public void deleteClient(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from client where id_client=:id_client");
		theQuery.setParameter("id_client", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public Client getClientEmail(String email) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		 Query qry = currentSession.createQuery("from Client where email_client=:email_client");
		 qry.setParameter("email_client", email);

		 Client theClient =(Client) qry.uniqueResult();
		
		return theClient;
	}


}
