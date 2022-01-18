package com.example.demorestservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;
    private Double balance = 0.00;
    @OneToOne
    private AppUser appUser;
}
