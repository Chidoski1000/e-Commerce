package com.example.demorestservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @OneToOne
    private AppUser appUser;
    @OneToMany
    private List<Product> product = new ArrayList<>();
    private boolean isActive;
    private Date dateCreated;
    private Date dateClosed;
}
