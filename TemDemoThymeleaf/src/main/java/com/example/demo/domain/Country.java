package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "capital")
	private String capital;

	public Country(String name, String capital) {
		this.name = name;
		this.capital = capital;
	}

	public Country() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCapital() {
		return capital;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Contry [id=" + id + ", name=" + name + ", capital=" + capital + "]";
	}

}
