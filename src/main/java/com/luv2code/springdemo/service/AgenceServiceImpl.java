package com.luv2code.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.AgenceDAO;
import com.luv2code.springdemo.dao.ClientDAO;
import com.luv2code.springdemo.entity.Agence;

@Service
public class AgenceServiceImpl implements AgenceService{
	
	// need to inject customer dao
	@Autowired
	private AgenceDAO agenceDAO;
	
	@Override
	@Transactional
	public Agence getAgence(int theId) {
		return agenceDAO.getAgence(theId);
	}

}
