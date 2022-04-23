package com.example.demorestservice.services.impl;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.entities.Role;
import com.example.demorestservice.exceptions.PasswordMismatchException;
import com.example.demorestservice.exceptions.UserDoesNotExist;
import com.example.demorestservice.exceptions.UserExistException;
import com.example.demorestservice.models.request.SignUpRequestDto;
import com.example.demorestservice.repositories.AppUserRepository;
import com.example.demorestservice.repositories.RoleRepository;
import com.example.demorestservice.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Eager
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    @Override
    public String registerUser(SignUpRequestDto userRequest) throws Exception {
        Optional<AppUser> checkEmail = appUserRepository.findAppUserByEmail(userRequest.getEmail());
        Optional<AppUser> checkUsername = appUserRepository.findByUsername(userRequest.getUsername());
        if(checkEmail.isEmpty()){
            if(checkUsername.isEmpty()) {
                if (!userRequest.getPassword().equals(userRequest.getRepeat_password()))
                    throw new PasswordMismatchException("Password does not match");
                AppUser appUser1 = modelMapper.map(userRequest, AppUser.class);
                appUser1.setPassword(passwordEncoder.encode(userRequest.getPassword()));
                appUserRepository.save(appUser1);
            }else {
                throw new UserExistException("Username already taken");
            }
        }else {
            throw new UserExistException("Email already exist");
        }
        return "User successfully Registered";
    }

    @Override
    public AppUser getAppUser(Long appUserId) {
        return appUserRepository.findById(appUserId).orElse(null);
    }

    @Override
    public AppUser getAppUserByUsername(String username) {
        return appUserRepository.findByUsername(username).orElse(null);
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
