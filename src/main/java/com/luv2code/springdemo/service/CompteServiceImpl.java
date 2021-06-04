package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CompteDAO;
import com.luv2code.springdemo.entity.Compte;

@Service
public class CompteServiceImpl implements CompteService{
	
	// need to inject customer dao
	@Autowired
	private CompteDAO compteDAO;
	
	@Override
	@Transactional
	public List<Compte> getComptes() {
		return compteDAO.getComptes();
	}

	@Override
	@Transactional
	public void saveCompte(Compte theCompte) {
		compteDAO.saveCompte(theCompte);
	}

	@Override
	@Transactional
	public Compte getCompte(int theId) {
		return compteDAO.getCompte(theId);
	}

	@Override
	@Transactional
	public void deleteCompte(int theId) {
		compteDAO.deleteCompte(theId);	
	}

}
