package com.example.demorestservice.controllerTest;

//import com.example.demorestservice.config.JwtAuthenticationEntryPoint;
import com.example.demorestservice.config.UserDetailServiceImpl;
import com.example.demorestservice.controllers.AppUserController;
import com.example.demorestservice.controllers.ProductController;
import com.example.demorestservice.filter.CustomAuthorizationFilter;
import com.example.demorestservice.filter.util.FilterUtil;

import com.example.demorestservice.models.request.LoginRequestDto;
import com.example.demorestservice.services.AppUserService;
import com.example.demorestservice.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDetailServiceImpl userDetailsService;

    @MockBean
    private ProductService productService;

//    @MockBean
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @MockBean
    private FilterUtil filterUtil;

    @MockBean
    private AppUserService appUserService;

    @MockBean
    private AuthenticationManager manager;


    @BeforeEach
    public void setUp(){
    }


    @Test
//    @WithMockUser("test@gmail.com")
    void getProductsf() throws Exception {

        mockMvc.perform(get("/api/product/"))
                .andExpect(status().isOk());

    }
}
