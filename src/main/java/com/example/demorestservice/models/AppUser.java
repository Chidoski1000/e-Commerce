package com.example.demorestservice.models;

import com.example.demorestservice.enums.AppUserType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private Date dob;
    private String address;
    private String phoneNo;
    private String state;
    private String username;
    private String password;
    private String nin;
    @Enumerated(EnumType.STRING)
    private AppUserType appUserType;
    private boolean isUserActive = false;
    private boolean isUserVerified = false;
    @CreationTimestamp
    private Date acctCreationDate;
    @OneToMany(mappedBy = "appUser")
    private List<Complaint> complaint;
    @OneToOne
    private Wallet wallet;
    private String acctNumber;
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
}
