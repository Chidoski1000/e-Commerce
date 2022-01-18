package com.example.demorestservice.services.impl;

import com.example.demorestservice.entities.Cart;
import com.example.demorestservice.entities.Product;
import com.example.demorestservice.repositories.CartRepository;
import com.example.demorestservice.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> getCart(Long cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public List<Product> getCartProducts(Long cartId) {
        return cartRepository.findProductsByCartId(cartId);
    }

    @Override
    public Cart addProductToCart(Product product, Long cartId) {
        if(getCart(cartId).isEmpty())
            return null;
        Cart cart = getCart(cartId).get();
        cart.getProduct().add(product);
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeProductFromCart(Product product, Long cartId) {
        if(getCart(cartId).isEmpty())
            return null;
        Cart cart = getCart(cartId).get();
        cart.getProduct().remove(product);
        return cartRepository.save(cart);

    }
}
