package com.example.demorestservice.services;

import com.example.demorestservice.entities.Cart;
import com.example.demorestservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CartService {

    Cart addCart(Cart cart);

    Optional<Cart> getCart(Long cartId);

    List<Cart> getAllCarts();

    List<Product> getCartProducts(Long cartId);

    Cart addProductToCart(Product product, Long cartId);

    Cart removeProductFromCart(Product product, Long cartId);

}
