package com.example.demo.service.impl;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Personnes;
import com.example.demo.repository.PersonnesRepository;
import com.example.demo.service.PersonneService;
import com.example.demo.service.dto.DataDto;
import com.example.demo.service.dto.PersonneCountryDto;
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<PersonneCountryDto> getPersonneCountry() {
		try {

			String query = "SELECT a.nom AS nom,a.telephone AS telephone,a.nationalite AS nationalite , c.capital AS capital,a.country AS country FROM Personnes a ,Country c WHERE a.country = c.name Order By a.nom Asc";

			final Query q = em.createQuery(query);
			
			return q.unwrap( org.hibernate.query.Query.class )
			        .setResultTransformer(Transformers.aliasToBean(PersonneCountryDto.class ) )
			        .getResultList();
			
		} catch (Exception e) {
			
			return Collections.emptyList();
		}
		
	}
	@Override
	public List<PersonneCountryDto> getPersonneCountryNamedQuery() {
		
		List<PersonneCountryDto> postDTOs = em.createQuery(
				    "select new " +
				    "   com.example.demo.service.dto.PersonneCountryDto(" +
				    "       a.nom, " +
				    "       c.capital, " +
				    "       a.telephone, " +
				    "       a.nationalite, " +
				    "       a.country " +
				    "   ) " +
				    "from Personnes a ,Country c " +
				    "WHERE a.country = c.name Order By a.nom Asc ", PersonneCountryDto.class).getResultList();
		
		 return postDTOs;
	}

}
