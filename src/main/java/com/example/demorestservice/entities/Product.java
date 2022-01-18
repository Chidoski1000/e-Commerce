package com.example.demorestservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String description;
    private String price;
    @OneToOne
    private DocumentFile productImage;

    public Product(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
// Admin, Collaborator, Dealer, Buyer