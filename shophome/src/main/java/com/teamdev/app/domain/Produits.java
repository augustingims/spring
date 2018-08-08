package com.teamdev.app.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A Produits.
 */
@Entity
@Table(name ="produits")
public class Produits implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "date_publication")
    private LocalDateTime datePublication;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "disponible", nullable = false)
    private Boolean disponible = false;

    @ManyToOne(optional = false)
	@JoinColumn(name = "users", referencedColumnName = "login", nullable = false)
    private Users user;
    
    @ManyToOne(optional = false)
	@JoinColumn(name = "monaire", referencedColumnName = "libelle", nullable = false)
    private Monaire monaire;
    
    @ManyToOne(optional = false)
	@JoinColumn(name = "souscategories", referencedColumnName = "libelle", nullable = false)
    private SousCategories souscategories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public LocalDateTime getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(LocalDateTime datePublication) {
		this.datePublication = datePublication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Monaire getMonaire() {
		return monaire;
	}

	public void setMonaire(Monaire monaire) {
		this.monaire = monaire;
	}

	public SousCategories getSouscategories() {
		return souscategories;
	}

	public void setSouscategories(SousCategories souscategories) {
		this.souscategories = souscategories;
	}

	@Override
	public String toString() {
		return "Produits [id=" + id + ", code=" + code + ", libelle=" + libelle + ", datePublication=" + datePublication
				+ ", description=" + description + ", price=" + price + ", disponible=" + disponible + ", user=" + user
				+ ", monaire=" + monaire + ", souscategories=" + souscategories + "]";
	}

   
}
