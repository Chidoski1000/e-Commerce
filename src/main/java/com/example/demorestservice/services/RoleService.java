package com.example.demorestservice.services;

import com.example.demorestservice.entities.Role;
import com.example.demorestservice.models.request.RoleRequestDto;

public interface RoleService {

    Role addRoleIfNotPresent(RoleRequestDto role);

    boolean removeRole(Long roleId);

    Role getRole(Long roleId);

    Role getRoleByName(String roleName);
}
