package com.teamdev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamdev.app.domain.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

}
