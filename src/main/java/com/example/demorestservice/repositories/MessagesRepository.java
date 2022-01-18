package com.example.demorestservice.repositories;

import com.example.demorestservice.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<AppUser, Long> {
}
