package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Client;

public interface ClientDAO {
	
	public List<?> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int theId);
	
	public Client getClientEmail(String email);

	public void deleteClient(int theId);

}
