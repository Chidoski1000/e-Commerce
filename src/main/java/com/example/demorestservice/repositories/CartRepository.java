package com.example.demorestservice.repositories;

import com.example.demorestservice.models.Cart;
import com.example.demorestservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Product> findProductsByCartId(Long cartId);
}
