package com.luv2code.springdemo.service;

import java.util.List;


import com.luv2code.springdemo.entity.Compte;

public interface CompteService {
	
	public List<Compte> getComptes();

	public void saveCompte(Compte theCompte);

	public Compte getCompte(int theId);

	public void deleteCompte(int theId);
}
