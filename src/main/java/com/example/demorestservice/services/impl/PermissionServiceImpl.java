package com.example.demorestservice.services.impl;

import com.example.demorestservice.entities.Permission;
import com.example.demorestservice.models.request.PermissionRequestDto;
import com.example.demorestservice.repositories.PermissionRepository;
import com.example.demorestservice.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission addRolePermission(PermissionRequestDto permission) {
        Permission permissionToAdd = new Permission();
        permissionToAdd.setName(permission.getName());
        return permissionRepository.save(permissionToAdd);
    }

    @Override
    public boolean removeRolePermission(Long permissionId) {
        if(getRolePermission(permissionId) != null) {
            permissionRepository.deleteById(permissionId);
            return true;
        }
        return false;
    }

    @Override
    public Permission getRolePermission(Long permissionId) {
        Optional<Permission> optionalPermission = permissionRepository.findById(permissionId);
        return optionalPermission.orElse(null);
    }
}
