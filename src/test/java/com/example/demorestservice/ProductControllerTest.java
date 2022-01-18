package com.example.demorestservice;

import com.example.demorestservice.controllers.ProductController;
import com.example.demorestservice.entities.DocumentFile;
import com.example.demorestservice.entities.Product;
import com.example.demorestservice.repositories.ProductRepository;
import com.example.demorestservice.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
    private MockMvc mockMvc;

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    Product PRODUCT_1 = new Product(1L, "Product_1", "test_1", "25000", new DocumentFile());
    Product PRODUCT_2 = new Product(2L, "Product_2", "test_2", "5000", new DocumentFile());
    Product PRODUCT_3 = new Product(3L, "Product_3", "test_3", "15000", new DocumentFile());

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }


    @Test
    public void getProducts() throws Exception {
    List<Product> productList = new ArrayList<>(Arrays.asList(PRODUCT_1, PRODUCT_2, PRODUCT_3));

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));

    }
}
