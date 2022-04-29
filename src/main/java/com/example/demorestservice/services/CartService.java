package com.example.demorestservice.services;

import com.example.demorestservice.models.Cart;
import com.example.demorestservice.models.Product;
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
