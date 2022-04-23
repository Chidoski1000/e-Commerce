package com.example.demorestservice.services;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.models.request.SignUpRequestDto;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
public interface AppUserService {

    String registerUser(SignUpRequestDto appUser) throws Exception;

    AppUser getAppUser(Long appUserId);

    AppUser getAppUserByUsername(String username);

    List<AppUser> getAllAppUsers();

    AppUser updateAppUserRecord(AppUser appUser);

    Boolean deleteAppUser(Long appUserId);

    Boolean deactivateAppUser(Long appUserId);

    Boolean addRoleToUser(String username, String roleName) throws RoleNotFoundException;

    Boolean removeRoleFromUser(String username, String roleName) throws RoleNotFoundException;


}
