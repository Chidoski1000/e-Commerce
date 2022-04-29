package com.example.demorestservice.repositories;

import com.example.demorestservice.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
