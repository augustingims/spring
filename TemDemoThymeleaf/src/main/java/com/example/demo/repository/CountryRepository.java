package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Country;


public interface CountryRepository extends JpaRepository<Country, Long>{

	@Query("Select a From Country a Where a.id =:id")
	Country getCountryWithId(@Param("id") Long id);
	
	@Query("Select a From Country a Where a.name =:name")
	Country getCountryWithName(@Param("name") String name);
	
	@Query("Select a From Country a Where a.capital =:capital")
	Country getCountryWithCapital(@Param("capital") String capital);
	
}
