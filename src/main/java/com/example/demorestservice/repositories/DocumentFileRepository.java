package com.example.demorestservice.repositories;

import com.example.demorestservice.models.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentFileRepository extends JpaRepository<DocumentFile, Long> {
}
