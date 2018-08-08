package com.teamdev.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monaire")
public class Monaire implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "libelle")
	private String libelle;
	
	@Column(name = "rapportxfa")
	private Double rapportxfa;
	
	@Column(name = "rapporteuro")
	private Double rapporteuro;
	
	@Column(name = "rapportdollar")
	private Double rapportdollar;
	
	@Column(name = "xfa", nullable = false)
    private Boolean xfa = false;
	
	@Column(name = "euro", nullable = false)
    private Boolean euro = false;
	
	@Column(name = "dollar", nullable = false)
    private Boolean dollar = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getRapportxfa() {
		return rapportxfa;
	}

	public void setRapportxfa(Double rapportxfa) {
		this.rapportxfa = rapportxfa;
	}

	public Double getRapporteuro() {
		return rapporteuro;
	}

	public void setRapporteuro(Double rapporteuro) {
		this.rapporteuro = rapporteuro;
	}

	public Double getRapportdollar() {
		return rapportdollar;
	}

	public void setRapportdollar(Double rapportdollar) {
		this.rapportdollar = rapportdollar;
	}

	public Boolean getXfa() {
		return xfa;
	}

	public void setXfa(Boolean xfa) {
		this.xfa = xfa;
	}

	public Boolean getEuro() {
		return euro;
	}

	public void setEuro(Boolean euro) {
		this.euro = euro;
	}

	public Boolean getDollar() {
		return dollar;
	}

	public void setDollar(Boolean dollar) {
		this.dollar = dollar;
	}

	@Override
	public String toString() {
		return "Monaire [id=" + id + ", libelle=" + libelle + ", rapportxfa=" + rapportxfa + ", rapporteuro="
				+ rapporteuro + ", rapportdollar=" + rapportdollar + ", xfa=" + xfa + ", euro=" + euro + ", dollar="
				+ dollar + "]";
	}
	
	
}
