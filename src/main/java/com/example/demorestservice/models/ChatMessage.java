package com.example.demorestservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatMessageId;
    @ManyToOne
    private AppUser appUser1;
    @ManyToOne
    private AppUser appUser2;
    @OneToMany(mappedBy = "chatMessage")
    private List<Messages> messages;
}
