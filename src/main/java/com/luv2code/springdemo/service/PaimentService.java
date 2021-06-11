package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Payment;
import com.luv2code.springdemo.entity.Transaction;

public interface PaimentService {
	public List<Payment> getPaiments();
	public void savePayment(Payment thePayment);
}
