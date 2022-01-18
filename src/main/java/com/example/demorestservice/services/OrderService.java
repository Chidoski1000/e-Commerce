package com.example.demorestservice.services;

import com.example.demorestservice.entities.Order;
import com.example.demorestservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order addOrder(Order order);

    Order getOrder(Long orderId);

    List<Product> getAllProductFromOrder(Long orderId);

    boolean updateOrderStatus(String orderStatus);

}
