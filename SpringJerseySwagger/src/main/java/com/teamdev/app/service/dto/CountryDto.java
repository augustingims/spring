package com.teamdev.app.service.dto;

public class CountryDto {

	private Integer id;
	private String name;
	private String capital;

	public CountryDto(String name, String capital) {
		this.name = name;
		this.capital = capital;
	}

	public CountryDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}
