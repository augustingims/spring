package com.teamdev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamdev.app.domain.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
