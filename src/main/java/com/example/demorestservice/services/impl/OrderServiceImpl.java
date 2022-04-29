package com.example.demorestservice.services.impl;

import com.example.demorestservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderServiceImpl {

    Product addProduct(Product product);

    Product getProduct(Long productId);

    List<Product> getAllProduct();

    Product updateProduct(Product product);

    Boolean deleteProduct(Long productId);

    List<Product> getSortedProduct(String field);

    Page<Product> getPageableProduct(int offset, int pageSize);


}
