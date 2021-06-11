package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="virement")
public class Virement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_virement")
	private int id_virement;
	
	@Column(name="montant_virement")
	private String montant_virement;
	
	@Column(name="num_source")
	private String num_source;
	
	public Virement() {
		
	}
	
	public int getId_virement() {
		return id_virement;
	}

	public void setId_virement(int id_virement) {
		this.id_virement = id_virement;
	}

	public String getMontant_virement() {
		return montant_virement;
	}

	public void setMontant_virement(String montant_virement) {
		this.montant_virement = montant_virement;
	}

	public String getNum_source() {
		return num_source;
	}

	public void setNum_source(String num_source) {
		this.num_source = num_source;
	}

	public String getNum_destin() {
		return num_destin;
	}

	public void setNum_destin(String num_destin) {
		this.num_destin = num_destin;
	}

	public int getTransaction_id_transaction() {
		return transaction_id_transaction;
	}

	public void setTransaction_id_transaction(int transaction_id_transaction) {
		this.transaction_id_transaction = transaction_id_transaction;
	}

	@Column(name="num_destin")
	private String num_destin;
	
	@JoinColumn(name="transaction_id_transaction")
	private int transaction_id_transaction;
}
