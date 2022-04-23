package com.example.demorestservice.serviceTest;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.models.request.SignUpRequestDto;
import com.example.demorestservice.repositories.AppUserRepository;
import com.example.demorestservice.repositories.RoleRepository;
import com.example.demorestservice.services.AppUserService;
import com.example.demorestservice.services.impl.AppUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {

    @InjectMocks
    private AppUserServiceImpl appUserService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AppUserRepository appUserRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void testRegister() throws Exception {
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto("Test", "1234",
                "1234", "test@gmail.com", "Tester", "Testing");

        AppUser appUser12 = new AppUser();
        when(modelMapper.map(signUpRequestDto, AppUser.class)).thenReturn(appUser12);
        String res = appUserService.registerUser(signUpRequestDto);
        assertThat(res).isNotNull();
    }

}