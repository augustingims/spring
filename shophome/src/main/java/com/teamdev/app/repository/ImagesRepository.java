package com.teamdev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamdev.app.domain.Images;

public interface ImagesRepository extends JpaRepository<Images, Long> {

}
