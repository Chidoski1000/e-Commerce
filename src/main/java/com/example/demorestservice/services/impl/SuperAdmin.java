package com.example.demorestservice.services.impl;

import com.example.demorestservice.request.RoleRequestDto;
import com.example.demorestservice.request.SignUpRequestDto;
import com.example.demorestservice.services.AppUserService;
import com.example.demorestservice.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SuperAdmin implements CommandLineRunner {
    private final RoleService roleService;
    private final AppUserService appUserService;

    @Override
    public void run(String... args) throws Exception {
            roleService.addRoleIfNotPresent(new RoleRequestDto("ROLE_ADMIN"));
            roleService.addRoleIfNotPresent(new RoleRequestDto("ROLE_COLLABORATOR"));
            roleService.addRoleIfNotPresent(new RoleRequestDto("ROLE_DEALER"));
            roleService.addRoleIfNotPresent(new RoleRequestDto("ROLE_BUYER"));

            if(appUserService.getAppUserByUsername("Test") == null) {
                appUserService.registerUser(new SignUpRequestDto("Test", "1234", "1234",
                        "test@gmail.com", "First", "Last"));
                appUserService.addRoleToUser("Test", "ROLE_ADMIN");
                appUserService.addRoleToUser("Test", "ROLE_DEALER");
            }
            if(appUserService.getAppUserByUsername("User") == null) {
                appUserService.registerUser(new SignUpRequestDto("User", "12345", "12345",
                        "user@gmail.com", "First", "Last"));
                appUserService.addRoleToUser("User", "ROLE_BUYER");
            }

    }
}
