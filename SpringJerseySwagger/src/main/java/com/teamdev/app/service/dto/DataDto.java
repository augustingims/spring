package com.teamdev.app.service.dto;

import java.io.Serializable;

/**
 * A Personnes.
 */
public class DataDto implements Serializable {

    private static final long serialVersionUID = 1L;

  
    private String nom;

    private String prenom;

    private String telephone;

    private String nationalite;


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


    public String getTelephone() {
        return telephone;
    }

    public DataDto telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNationalite() {
        return nationalite;
    }

    public DataDto nationalite(String nationalite) {
        this.nationalite = nationalite;
        return this;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

}
