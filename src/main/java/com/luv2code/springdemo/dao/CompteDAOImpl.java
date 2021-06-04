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
public class CompteDAOImpl implements CompteDAO{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Compte> getComptes() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query query = 
				currentSession.createQuery("from Compte");
		List<Compte> list = query.list();
		
				
		// return the results		
		return list;
	}

	@Override
	public void saveCompte(Compte theCompte) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCompte);
		
	}

	@Override
	public Compte getCompte(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Compte theCompte = currentSession.get(Compte.class, theId);
		
		return theCompte;
	}

	@Override
	public void deleteCompte(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from compte where id_compte=:id_compte");
		theQuery.setParameter("id_compte", theId);
		
		theQuery.executeUpdate();
	}

}
