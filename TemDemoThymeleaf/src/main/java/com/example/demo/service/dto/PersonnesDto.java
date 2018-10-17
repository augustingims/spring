package com.example.demo.service.dto;

import java.io.Serializable;

/**
 * A Personnes.
 */
public class PersonnesDto implements Serializable {

    private static final long serialVersionUID = 1L;

  
    private Long id;

    private String nom;

    private String prenom;

    private String dateNaissance;

    private String lieuNaissance;

    private String telephone;

    private String sexe;

    private String nationalite;
    
    private String country;

    public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public PersonnesDto telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public PersonnesDto sexe(String sexe) {
        this.sexe = sexe;
        return this;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNationalite() {
        return nationalite;
    }

    public PersonnesDto nationalite(String nationalite) {
        this.nationalite = nationalite;
        return this;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @Override
    public String toString() {
        return "Personnes{" +
            "id=" + id +
            ", nom='" + nom + '\'' +
            ", prenom='" + prenom + '\'' +
            ", dateNaissance='" + dateNaissance + '\'' +
            ", lieuNaissance='" + lieuNaissance + '\'' +
            ", telephone='" + telephone + '\'' +
            ", sexe='" + sexe + '\'' +
            ", country='" + country + '\'' +
            ", nationalite='" + nationalite + '\'' +
            '}';
    }
}
