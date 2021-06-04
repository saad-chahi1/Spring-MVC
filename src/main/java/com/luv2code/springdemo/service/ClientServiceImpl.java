package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ClientDAO;
import com.luv2code.springdemo.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	// need to inject customer dao
	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	@Transactional
	public List<?> getClients() {
		return clientDAO.getClients();
	}

	@Override
	@Transactional
	public void saveClient(Client theClient) {
		clientDAO.saveClient(theClient);
	}

	@Override
	@Transactional
	public Client getClient(int theId) {
		return clientDAO.getClient(theId);
	}

	@Override
	@Transactional
	public void deleteClient(int theId) {
		clientDAO.deleteClient(theId);
	}
}





