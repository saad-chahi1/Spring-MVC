package com.luv2code.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.PaymentDAO;
import com.luv2code.springdemo.dao.VirementDAO;
import com.luv2code.springdemo.entity.Virement;

@Service
public class VirementServiceImpl implements VirementService{
	
	@Autowired
	private VirementDAO virementDAO;
	
	@Override
	@Transactional
	public void saveVirement(Virement theVirement) {
		virementDAO.saveVirement(theVirement);
		
	}

}
