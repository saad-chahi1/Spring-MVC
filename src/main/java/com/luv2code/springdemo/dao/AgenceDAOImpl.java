package com.luv2code.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Agence;
import com.luv2code.springdemo.entity.Client;

@Repository
public class AgenceDAOImpl implements AgenceDAO{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Agence getAgence(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Agence theClient = currentSession.get(Agence.class, theId);
		
		return theClient;
	}

}
