package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Override
	public String toString() {
		return "Paiment [id_payment=" + id_payment + ", code_facture=" + code_facture + ", montant_payment="
				+ montant_payment + ", transaction_id_transaction=" + transaction_id_transaction + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_payment")
	private int id_payment;
	
	public int getId_payment() {
		return id_payment;
	}

	public void setId_payment(int id_payment) {
		this.id_payment = id_payment;
	}

	public String getCode_facture() {
		return code_facture;
	}

	public void setCode_facture(String code_facture) {
		this.code_facture = code_facture;
	}

	public String getMontant_payment() {
		return montant_payment;
	}

	public void setMontant_payment(String montant_payment) {
		this.montant_payment = montant_payment;
	}

	public int getTransaction_id_transaction() {
		return transaction_id_transaction;
	}

	public void setTransaction_id_transaction(int transaction_id_transaction) {
		this.transaction_id_transaction = transaction_id_transaction;
	}

	@Column(name="code_facture")
	private String code_facture;
	
	@Column(name="montant_payment")
	private String montant_payment;
	
	@JoinColumn(name="transaction_id_transaction")
	private int transaction_id_transaction;
	
	public Payment(){
		
	}
}
