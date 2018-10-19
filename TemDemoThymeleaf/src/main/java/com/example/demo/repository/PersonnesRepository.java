package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Personnes;
import com.example.demo.service.dto.PersonneCountryDto;


/**
 * Spring Data JPA repository for the Personnes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PersonnesRepository extends JpaRepository<Personnes, Long> {

    Personnes findByNomOrTelephone(String nom, String tel);
    Personnes findByTelephone(String tel);
    Personnes findByNom(String nom);
    
    @Query("select new com.example.demo.service.dto.PersonneCountryDto(a.nom, c.capital, a.telephone,a.nationalite,a.country) from Personnes a ,Country c WHERE a.country = c.name Order By a.nom Asc ")
    List<PersonneCountryDto> getPersonneCountry();
}
