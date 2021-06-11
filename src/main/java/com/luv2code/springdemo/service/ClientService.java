package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Client;

public interface ClientService {

	public List<?> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int theId);
	
	public Client getClientEmail(String email);

	public void deleteClient(int theId);
	
}
