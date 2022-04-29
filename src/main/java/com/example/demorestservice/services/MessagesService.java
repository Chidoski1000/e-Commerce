package com.example.demorestservice.services;

import com.example.demorestservice.models.Messages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessagesService {

    Messages addMessage(Messages message);

    Messages getMessages(Long messagesId);

    List<Messages> getAllMessages();

}
