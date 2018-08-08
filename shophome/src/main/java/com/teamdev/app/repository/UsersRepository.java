package com.teamdev.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamdev.app.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
     
     Optional<Users> findByEmail(String email);

     Optional<Users> findByUsernameOrEmail(String username, String email);

     List<Users> findByIdIn(List<Long> userIds);

     Optional<Users> findByUsername(String username);

     Boolean existsByUsername(String username);

     Boolean existsByEmail(String email);
     
}
