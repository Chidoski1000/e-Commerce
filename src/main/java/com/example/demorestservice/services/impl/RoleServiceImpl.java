package com.example.demorestservice.services.impl;

import com.example.demorestservice.entities.Role;
import com.example.demorestservice.models.request.RoleRequestDto;
import com.example.demorestservice.repositories.RoleRepository;
import com.example.demorestservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRoleIfNotPresent(RoleRequestDto role) {
        if(getRoleByName(role.getName()) != null)
            return null;
        Role roleToAdd = new Role();
        roleToAdd.setName(role.getName());

        return roleRepository.save(roleToAdd);
    }

    @Override
    public boolean removeRole(Long roleId) {
        if(getRole(roleId) != null) {
            roleRepository.deleteById(roleId);
            return true;
        }
        return false;
    }

    @Override
    public Role getRole(Long roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        return optionalRole.orElse(null);
    }

    @Override
    public Role getRoleByName(String roleName) {
        Optional<Role> optionalRole = roleRepository.findByName(roleName);
        return optionalRole.orElse(null);
    }
}
