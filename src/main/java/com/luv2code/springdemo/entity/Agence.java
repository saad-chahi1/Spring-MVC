package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="agence")
public class Agence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agence")
	private int id_agence;
	
	@Column(name="code_agence")
	private String code_agence;
	
	@Column(name="Nom_agence")
	private String nom_agence;
	
	@Column(name="horaire_debut")
	private String horaire_debut;
	
	@Column(name="horaire_fin")
	private String horaire_fin;
	
	@Column(name="telephone_agence")
	private String telephone_agence;
	
	@Column(name="directeur_agence")
	private String directeur_agence;
	
	@JoinColumn(name="banque_id_banque")
	private int banque_id_banque;
	
	@JoinColumn(name="adresse_id_adresse")
	private int adresse_id_adresse;
	
	public Agence() {
		
	}

	public int getId_agence() {
		return id_agence;
	}

	public void setId_agence(int id_agence) {
		this.id_agence = id_agence;
	}

	public String getCode_agence() {
		return code_agence;
	}

	public void setCode_agence(String code_agence) {
		this.code_agence = code_agence;
	}

	public String getNom_agence() {
		return nom_agence;
	}

	public void setNom_agence(String nom_agence) {
		this.nom_agence = nom_agence;
	}

	public String getHoraire_debut() {
		return horaire_debut;
	}

	public void setHoraire_debut(String horaire_debut) {
		this.horaire_debut = horaire_debut;
	}

	public String getHoraire_fin() {
		return horaire_fin;
	}

	public void setHoraire_fin(String horaire_fin) {
		this.horaire_fin = horaire_fin;
	}

	public String getTelephone_agence() {
		return telephone_agence;
	}

	public void setTelephone_agence(String telephone_agence) {
		this.telephone_agence = telephone_agence;
	}

	public String getDirecteur_agence() {
		return directeur_agence;
	}

	public void setDirecteur_agence(String directeur_agence) {
		this.directeur_agence = directeur_agence;
	}

	public int getBanque_id_banque() {
		return banque_id_banque;
	}

	public void setBanque_id_banque(int banque_id_banque) {
		this.banque_id_banque = banque_id_banque;
	}

	public int getAdresse_id_adresse() {
		return adresse_id_adresse;
	}

	public void setAdresse_id_adresse(int adresse_id_adresse) {
		this.adresse_id_adresse = adresse_id_adresse;
	}

}
