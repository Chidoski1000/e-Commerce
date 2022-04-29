package com.example.demorestservice.controllerTest;

//import com.example.demorestservice.config.JwtAuthenticationEntryPoint;
import com.example.demorestservice.config.UserDetailServiceImpl;
import com.example.demorestservice.controllers.ProductController;
import com.example.demorestservice.filter.util.FilterUtil;

import com.example.demorestservice.services.AppUserService;
import com.example.demorestservice.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;

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
