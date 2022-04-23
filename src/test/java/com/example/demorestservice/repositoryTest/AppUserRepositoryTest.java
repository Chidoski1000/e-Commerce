package com.example.demorestservice.repositoryTest;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.repositories.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AppUserRepositoryTest {
    private final AppUserRepository appUserRepository;
    private AppUser user;

    @Autowired
    public AppUserRepositoryTest(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @BeforeEach
    void setUp() {
        user = new AppUser();
        user.setEmail("og@gmail.com");
        user.setPassword("12345678");
        user.setFirstName("Test");
    }

    @Test
    void saveUser() {
        AppUser savedUser = appUserRepository.save(user);
        assertThat(savedUser).isNotNull().isEqualTo(user);
    }
}
