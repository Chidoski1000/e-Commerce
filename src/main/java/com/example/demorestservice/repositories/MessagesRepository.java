package com.example.demorestservice.repositories;

import com.example.demorestservice.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<AppUser, Long> {
}
