package com.example.demorestservice.models;

import com.example.demorestservice.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Buyer_Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @OneToOne
    private AppUser buyer;
    @OneToOne
    private AppUser seller;
    @OneToMany
    private List<Product> productList;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
