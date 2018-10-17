package com.teamdev.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teamdev.app.domain.Personnes;
import com.teamdev.app.repository.PersonnesRepository;
import com.teamdev.app.service.PersonneService;
import com.teamdev.app.service.dto.DataDto;
import com.teamdev.app.service.dto.PersonnesDto;

@Service
public class PersonneServiceImpl implements PersonneService {

	ModelMapper mapper = new ModelMapper();

	@Autowired
	private EntityManager em;

	@Autowired
	private PersonnesRepository personnesRepository;

	@Override
	public Page<Personnes> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
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

}
