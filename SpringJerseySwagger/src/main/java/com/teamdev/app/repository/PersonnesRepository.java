package com.teamdev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamdev.app.domain.Personnes;


/**
 * Spring Data JPA repository for the Personnes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PersonnesRepository extends JpaRepository<Personnes, Long> {

    Personnes findByNomOrTelephone(String nom, String tel);
    Personnes findByTelephone(String tel);
    Personnes findByNom(String nom);
}
