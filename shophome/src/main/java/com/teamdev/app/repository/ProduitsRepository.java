package com.teamdev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamdev.app.domain.Produits;

public interface ProduitsRepository extends JpaRepository<Produits, Long> {

}
