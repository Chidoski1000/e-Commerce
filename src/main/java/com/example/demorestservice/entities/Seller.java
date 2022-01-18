//package com.example.demorestservice.entities;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Data
//public class Seller {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long sellerId;
//    private String firstName;
//    private String lastName;
//    private Date dob;
//    private String address;
//    private String phoneNo;
//    private String state;
//    private String username;
//    private String password;
//    private String nin;
//    private boolean isUserActivated = false;
//    private boolean isUserVerified =false;
//    private Date acctCreationDate;
//    @OneToMany
//    private List<Complaint> complaint;
//    @OneToOne
//    private Wallet wallet;
//}
