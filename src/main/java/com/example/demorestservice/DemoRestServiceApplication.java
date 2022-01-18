package com.example.demorestservice;

import com.example.demorestservice.models.request.RoleRequestDto;
import com.example.demorestservice.models.request.SignUpRequestDto;
import com.example.demorestservice.services.AppUserService;
import com.example.demorestservice.services.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestServiceApplication.class, args);

	}

	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(RoleService roleService, AppUserService appUserService){
		return args -> {
			roleService.addRoleIfNotPresent(new RoleRequestDto("ROLE_ADMIN"));
			roleService.addRoleIfNotPresent(new RoleRequestDto("ROLE_COLLABORATOR"));
        	roleService.addRoleIfNotPresent(new RoleRequestDto("ROLE_DEALER"));
			roleService.addRoleIfNotPresent(new RoleRequestDto("ROLE_BUYER"));

			if(appUserService.getAppUserByUsername("Test") == null)
			appUserService.registerUser(new SignUpRequestDto("Test", "1234", "1234",
					"test@gmail.com", "First", "Last"));
			appUserService.addRoleToUser("Test", "ROLE_ADMIN");
			appUserService.addRoleToUser("Test", "ROLE_DEALER");
		};
	}

}
