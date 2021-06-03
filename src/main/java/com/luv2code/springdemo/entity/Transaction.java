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
	
	@Column(name="type_transaction")
	private String type_transaction;
	
	@Column(name="date_transaction")
	private String date_transaction;
	
	@Column(name="heure_transaction")
	private String heure_transaction;
	
	@JoinColumn(name="id_client")
	private int client_id_client;
}
