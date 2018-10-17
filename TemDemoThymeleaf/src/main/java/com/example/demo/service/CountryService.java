package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.Country;

public interface CountryService {
		
	Country getCountryWithName(String name);
	
	Country getCountryWithCapital(String capital);

	Country save(Country country);

	Page<Country> findAll(Pageable pageable);

	Country findOne(Long id);

	void delete(Long id);
	
	List<Country> getListeCountryWthMax(String name,String capital, Long resultatmax);
	
	List<Country> getListeCountry(String name,String capital);
	
	Country getCountry(String name);

	Country getCountryWithId(Long id);


}
