package com.example.demorestservice.repositories;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.entities.Cart;
import com.example.demorestservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Product> findProductsByCartId(Long cartId);
}
