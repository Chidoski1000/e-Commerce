package com.example.demorestservice.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackID;
    @ManyToOne
    private Complaint complaint;
    private String feedBackResponse;

}
