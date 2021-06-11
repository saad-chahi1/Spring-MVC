package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_transaction")
	private int id_transaction;
	
	public int getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}

	public String getDate_transaction() {
		return date_transaction;
	}

	public void setDate_transaction(String date_transaction) {
		this.date_transaction = date_transaction;
	}

	public String getHeure_transaction() {
		return heure_transaction;
	}

	public void setHeure_transaction(String heure_transaction) {
		this.heure_transaction = heure_transaction;
	}

	public int getClient_id_client() {
		return client_id_client;
	}

	public void setClient_id_client(int client_id_client) {
		this.client_id_client = client_id_client;
	}

	@Column(name="type_transaction")
	private String type_transaction;
	
	public String getType_transaction() {
		return type_transaction;
	}

	public void setType_transaction(String type_transaction) {
		this.type_transaction = type_transaction;
	}

	@Column(name="date_transaction")
	private String date_transaction;
	
	@Column(name="heure_transaction")
	private String heure_transaction;
	
	@Column(name="client_id_client")
	private int client_id_client;
	
	public Transaction() {
		
	}
}
