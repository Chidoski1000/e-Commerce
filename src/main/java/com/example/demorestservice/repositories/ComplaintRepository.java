package com.example.demorestservice.repositories;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
