package com.example.demorestservice.services;

import com.example.demorestservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Product addProduct(Product product);

    Product getProduct(Long productId);

    List<Product> getAllProduct();

    Product updateProduct(Product product);

    Boolean deleteProduct(Long productId);

    List<Product> getSortedProduct(String field);

    Page<Product> getPageableProduct(int offset, int pageSize);


}
