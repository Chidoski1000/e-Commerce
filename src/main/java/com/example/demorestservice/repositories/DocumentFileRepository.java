package com.example.demorestservice.repositories;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.entities.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentFileRepository extends JpaRepository<DocumentFile, Long> {
}
