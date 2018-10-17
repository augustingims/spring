package com.teamdev.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teamdev.app.domain.Personnes;
import com.teamdev.app.service.dto.DataDto;
import com.teamdev.app.service.dto.PersonnesDto;

public interface PersonneService {
	
	Personnes save(PersonnesDto personne);

	Page<Personnes> findAll(Pageable pageable);

	Personnes findOne(Long id);

	void delete(Long id);
	
	List<DataDto >getListeCostumData();

}
