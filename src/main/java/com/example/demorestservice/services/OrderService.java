package com.example.demorestservice.services;

import com.example.demorestservice.models.Order;
import com.example.demorestservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order addOrder(Order order);

    Order getOrder(Long orderId);

    List<Product> getAllProductFromOrder(Long orderId);

    boolean updateOrderStatus(String orderStatus);

}
