package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private int id_client;
	
	@Column(name="code_client")
	private String code_client;
	
	@Column(name="cin_client")
	private String cin_client;
	
	@Column(name="nom_client")
	private String nom_client;
	
	@Column(name="prenom_client")
	private String prenom_client;
	
	@Column(name="type_client")
	private String type_client;
	
	@Column(name="tele_client")
	private String tele_client;
	
	@Column(name="email_client")
	private String email_client;
	
	@Column(name="date_creation")
	private String date_creation;
	
	@Column(name="etat_client")
	private String etat_client;
	
	@Column(name="password_client")
	private String password_client;
	
	@JoinColumn(name="id_agence")
	private int agence_id_agence;
	
	@JoinColumn(name="id_compte")
	private int compte_id_compte;

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getCode_client() {
		return code_client;
	}

	public void setCode_client(String code_client) {
		this.code_client = code_client;
	}

	public String getCin_client() {
		return cin_client;
	}

	public void setCin_client(String cin_client) {
		this.cin_client = cin_client;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	public String getType_client() {
		return type_client;
	}

	public void setType_client(String type_client) {
		this.type_client = type_client;
	}

	public String getTele_client() {
		return tele_client;
	}

	public void setTele_client(String tele_client) {
		this.tele_client = tele_client;
	}

	public String getEmail_client() {
		return email_client;
	}

	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}

	public String getDate_creation() {
		return date_creation;
	}

	public void setDate_client(String date_client) {
		this.date_creation = date_client;
	}

	public String getEtat_client() {
		return etat_client;
	}

	public void setEtat_client(String etat_client) {
		this.etat_client = etat_client;
	}

	public String getPassword_client() {
		return password_client;
	}

	public void setPassword_client(String password_client) {
		this.password_client = password_client;
	}

	public int getAgence_id_agence() {
		return agence_id_agence;
	}

	public void setAgence_id_agence(int agence_id_agence) {
		this.agence_id_agence = agence_id_agence;
	}

	public int getCompte_id_compte() {
		return compte_id_compte;
	}

	public void setCompte_id_compte(int compte_id_compte) {
		this.compte_id_compte = compte_id_compte;
	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", code_client=" + code_client + ", cin_client=" + cin_client
				+ ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + ", type_client=" + type_client
				+ ", tele_client=" + tele_client + ", email_client=" + email_client + ", date_client=" + date_creation
				+ ", etat_client=" + etat_client + ", password_client=" + password_client + ", agence_id_agence="
				+ agence_id_agence + ", compte_id_compte=" + compte_id_compte + "]";
	}

	public Client(int id_client, String code_client, String cin_client, String nom_client, String prenom_client,
			String type_client, String tele_client, String email_client, String date_client, String etat_client,
			String password_client, int agence_id_agence, int compte_id_compte) {
		super();
		this.id_client = id_client;
		this.code_client = code_client;
		this.cin_client = cin_client;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.type_client = type_client;
		this.tele_client = tele_client;
		this.email_client = email_client;
		this.date_creation = date_client;
		this.etat_client = etat_client;
		this.password_client = password_client;
		this.agence_id_agence = agence_id_agence;
		this.compte_id_compte = compte_id_compte;
	}
	public Client() {
		
	}
	
}
