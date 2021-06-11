package com.luv2code.springdemo.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Client;
import com.luv2code.springdemo.entity.Compte;
import com.luv2code.springdemo.entity.Payment;
import com.luv2code.springdemo.entity.Transaction;
import com.luv2code.springdemo.service.ClientService;
import com.luv2code.springdemo.service.CompteService;
import com.luv2code.springdemo.service.TransactionService;

@Repository
public class PaymentDAOImpl implements PaymentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	TransactionService ts;
	@Autowired
	CompteService theClient;

	@Override
	public void savePayment(Payment thePayment) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		int k =getLast();
		
		Transaction newTr = new Transaction();
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dateFormat.format(date);  
		newTr.setDate_transaction(strDate);
		DateFormat dateFormat1 = new SimpleDateFormat("hh:mm");  
		String strDate1 = dateFormat1.format(date); 
		newTr.setHeure_transaction(strDate1);
		if(thePayment.getCode_facture().charAt(0) == '0') {
			newTr.setType_transaction("Recharge");
		}else {
			newTr.setType_transaction("paiement");
		}
		
		newTr.setClient_id_client(1);
		newTr.setId_transaction(0);
		Compte client = theClient.getCompte(newTr.getClient_id_client());
		if(Integer.parseInt(client.getSolde()) > Integer.parseInt(thePayment.getMontant_payment())){
			currentSession.saveOrUpdate(newTr);
			
			thePayment.setTransaction_id_transaction(k);
			// save/upate the customer ... finally LOL
			currentSession.saveOrUpdate(thePayment);
			
			int soldeIn = Integer.parseInt(client.getSolde())-Integer.parseInt(thePayment.getMontant_payment());
			
			client.setSolde(String.valueOf(soldeIn));
			currentSession.saveOrUpdate(client);
		}
		
				
	}
	public int getLast() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Transaction");
		List<Transaction> list = query.list();
		Transaction theClient = (Transaction) list.get(list.size()-1);
		int id_client=theClient.getId_transaction()+1;
		return id_client;
	}

	@Override
	public List<Payment> getPaiments() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query query = 
				currentSession.createQuery("from Payment");
		List<Payment> list = query.list();
						
		// return the results		
		return list;
	}

}
