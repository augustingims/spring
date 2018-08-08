package com.teamdev.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamdev.app.domain.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

	Optional<Roles> findByName(String roleName);
}
