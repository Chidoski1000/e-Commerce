package com.example.demorestservice.repositories;

import com.example.demorestservice.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findAppUserByEmail(String email);

    Optional<AppUser> findByUsername(String username);
}
