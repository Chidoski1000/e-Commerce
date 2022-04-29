package com.example.demorestservice.repositories;

import com.example.demorestservice.models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
