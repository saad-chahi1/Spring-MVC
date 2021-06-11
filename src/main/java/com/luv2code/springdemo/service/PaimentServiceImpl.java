package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ClientDAO;
import com.luv2code.springdemo.dao.PaymentDAO;
import com.luv2code.springdemo.entity.Payment;

@Service
public class PaimentServiceImpl implements PaimentService{
	
	@Autowired
	private PaymentDAO paymentDAO;

	@Override
	@Transactional
	public void savePayment(Payment thePayment) {
		paymentDAO.savePayment(thePayment);		
	}

	@Override
	@Transactional
	public List<Payment> getPaiments() {
		return paymentDAO.getPaiments();
	}

}
