package com.example.demorestservice.services.impl;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.entities.Role;
import com.example.demorestservice.exceptions.PasswordMismatchException;
import com.example.demorestservice.exceptions.UserExist;
import com.example.demorestservice.models.request.SignUpRequestDto;
import com.example.demorestservice.repositories.AppUserRepository;
import com.example.demorestservice.repositories.RoleRepository;
import com.example.demorestservice.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Eager
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser registerUser(SignUpRequestDto appUser) throws Exception {
        if(appUserRepository.findByEmail(appUser.getEmail()) != null)
            throw new UserExist();
        if(!appUser.getPassword().equals(appUser.getRepeat_password()))
            throw new PasswordMismatchException();
        AppUser appUser1 = new AppUser();
        appUser1.setFirstName(appUser.getFirstName());
        appUser1.setLastName(appUser.getLastName());
        appUser1.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser1.setEmail(appUser.getEmail());
        appUser1.setUsername(appUser.getUsername());
        return appUserRepository.save(appUser1);
    }

    @Override
    public AppUser getAppUser(Long appUserId) {
        Optional<AppUser> appUser = appUserRepository.findById(appUserId);
        return appUser.orElse(null);
    }

    @Override
    public AppUser getAppUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser updateAppUserRecord(AppUser appUser) {
        AppUser appUser1 = getAppUser(appUser.getUserId());
        appUser1.setUsername(appUser.getUsername());
        appUser1.setPassword(appUser.getPassword());
        appUser1.setLastName(appUser.getLastName());
        appUser1.setFirstName(appUser.getFirstName());
        appUser1.setEmail(appUser.getEmail());
        return appUserRepository.save(appUser1);
    }

    @Override
    public Boolean deleteAppUser(Long appUserId) {
        AppUser appUser = getAppUser(appUserId);
        if(appUser != null) {
            appUserRepository.delete(appUser);
            return true;
        }
        else
            return false;
    }

    @Override
    public Boolean deactivateAppUser(Long appUserId) {
        AppUser appUser = getAppUser(appUserId);
        if(appUser != null){
            appUser.setUserActive(false);
            appUserRepository.save(appUser);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean addRoleToUser(String username, String roleName) throws RoleNotFoundException {
        AppUser appUser = getAppUserByUsername(username);
        Optional<Role> optionalRole = roleRepository.findByName(roleName);
        if(optionalRole.isEmpty())
            throw new RoleNotFoundException();
        Role role = optionalRole.get();
        return appUser.getRoles().add(role);
    }

    @Override
    public Boolean removeRoleFromUser(String username, String roleName) throws RoleNotFoundException {
        AppUser appUser = getAppUserByUsername(username);
        Optional<Role> optionalRole = roleRepository.findByName(roleName);
        if(optionalRole.isEmpty())
            throw new RoleNotFoundException();
        Role role = optionalRole.get();
        return appUser.getRoles().remove(role);
    }
}
