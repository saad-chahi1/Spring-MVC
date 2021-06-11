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

import com.luv2code.springdemo.entity.Compte;
import com.luv2code.springdemo.entity.Transaction;
import com.luv2code.springdemo.entity.Virement;
import com.luv2code.springdemo.service.CompteService;
import com.luv2code.springdemo.service.TransactionService;

@Repository
public class VirementDAOImpl implements VirementDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	TransactionService ts;
	@Autowired
	CompteService theClient;
	
	
	@Override
	public void saveVirement(Virement theVir) {
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
		newTr.setType_transaction("Virement");
		
		newTr.setClient_id_client(1);
		newTr.setId_transaction(0);
		Compte client = theClient.getCompte(getTheIdOfClient(theVir.getNum_source()));
		Compte clientDist = theClient.getCompte(getTheIdOfClient(theVir.getNum_destin()));
		if(Integer.parseInt(client.getSolde()) > Integer.parseInt(theVir.getMontant_virement())){
			currentSession.saveOrUpdate(newTr);
			
			theVir.setTransaction_id_transaction(k);
			// save/upate the customer ... finally LOL
			currentSession.saveOrUpdate(theVir);
			
			int soldeIn = Integer.parseInt(client.getSolde())-Integer.parseInt(theVir.getMontant_virement());
			int soldeDest = Integer.parseInt(clientDist.getSolde())+Integer.parseInt(theVir.getMontant_virement());
			
			client.setSolde(String.valueOf(soldeIn));
			clientDist.setSolde(String.valueOf(soldeDest));
			currentSession.saveOrUpdate(client);
			currentSession.saveOrUpdate(clientDist);
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
	public int getTheIdOfClient(String theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Compte where num_compte=:num_compte");
		query.setParameter("num_compte", theId);
		List<Compte> list = query.list();	
		Compte tr = new Compte();
		for (Compte transaction : list) {
			tr = transaction;
		}
		return tr.getId_compte();
	}
}
