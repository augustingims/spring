package com.example.demo.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Personnes;
import com.example.demo.repository.PersonnesRepository;
import com.example.demo.service.PersonneService;
import com.example.demo.service.dto.DataDto;
import com.example.demo.service.dto.PersonnesDto;

@Service
public class PersonneServiceImpl implements PersonneService {

	ModelMapper mapper = new ModelMapper();

	@Autowired
	private EntityManager em;

	@Autowired
	private PersonnesRepository personnesRepository;

	@Override
	public List<Personnes> findAll() {
		return personnesRepository.findAll();
	}

	@Override
	public Personnes findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Personnes save(PersonnesDto personneDto) {
		Personnes personne = mapper.map(personneDto, Personnes.class);
		personnesRepository.save(personne);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataDto> getListeCostumData() {
		Query q = null;
		try {

			String query = "Select a.nom,a.prenom,a.telephone,a.nationalite from Personnes a where 1=1 ";

			query += " Order By a.nom Asc";

			q = em.createQuery(query,DataDto.class);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return q.getResultList();
	}

	@Override
	public void saveAll(List<Personnes> personnes) {
		
		for(Personnes pers:personnes) {
			System.out.println(pers.getId());
			personnesRepository.save(pers);
		}
		
	}

}
