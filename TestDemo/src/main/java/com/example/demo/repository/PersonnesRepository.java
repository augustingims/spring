package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domains.Personnes;

public interface PersonnesRepository extends JpaRepository<Personnes, Long> {
	Personnes findByNom(String nom);
}
