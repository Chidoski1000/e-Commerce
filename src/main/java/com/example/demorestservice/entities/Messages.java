package com.example.demorestservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
public class Messages {

    @Id
    private Long messageId;
    private String messageBody;
    private Date timeSent;
    @ManyToOne
    private ChatMessage chatMessage;
    @OneToOne
    private AppUser sender;
    @OneToOne
    private AppUser receiver;
}
