package com.example.demorestservice.repositories;

import com.example.demorestservice.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
