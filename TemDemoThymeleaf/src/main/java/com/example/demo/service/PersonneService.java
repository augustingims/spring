package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.Personnes;
import com.example.demo.service.dto.DataDto;
import com.example.demo.service.dto.PersonnesDto;

public interface PersonneService {
	
	Personnes save(PersonnesDto personne);

	List<Personnes> findAll();

	Personnes findOne(Long id);

	void delete(Long id);
	
	void saveAll(List<Personnes> personnes);
	
	List<DataDto >getListeCostumData();

}
