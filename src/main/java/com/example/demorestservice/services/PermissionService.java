package com.example.demorestservice.services;

import com.example.demorestservice.models.Permission;
import com.example.demorestservice.request.PermissionRequestDto;


public interface PermissionService {

    Permission addRolePermission(PermissionRequestDto permission);

    boolean removeRolePermission(Long permissionId);

    Permission getRolePermission(Long permissionId);
}
