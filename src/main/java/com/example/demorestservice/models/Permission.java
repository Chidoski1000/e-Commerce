package com.example.demorestservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Collection<Role> roles;
}
