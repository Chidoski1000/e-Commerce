package com.example.demorestservice.entities;

import com.example.demorestservice.enums.ComplaintStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;
    @ManyToOne
    private AppUser complainer;
    @ManyToOne
    private AppUser complainee;
    private Date dateComplained;
    private String complaintDescription;
    @OneToMany(mappedBy = "complaint")
    private List<Feedback> feedbacks;
    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;
    @ManyToOne
    private AppUser appUser;

}
