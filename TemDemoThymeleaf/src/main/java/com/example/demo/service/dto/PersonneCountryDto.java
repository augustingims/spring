package com.example.demo.service.dto;

import java.io.Serializable;

/**
 * A Personne Country.
 */
public class PersonneCountryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nom;

	private String capital;

	private String telephone;

	private String nationalite;

	private String country;

	public String getCountry() {
		return country;
	}

	public PersonneCountryDto(String nom, String capital, String telephone, String nationalite, String country) {
		super();
		this.nom = nom;
		this.capital = capital;
		this.telephone = telephone;
		this.nationalite = nationalite;
		this.country = country;
	}

	public String getNom() {
		return nom;
	}

	public String getCapital() {
		return capital;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
