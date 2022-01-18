package com.example.demorestservice.services;

import com.example.demorestservice.entities.Messages;
import com.example.demorestservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessagesService {

    Messages addMessage(Messages message);

    Messages getMessages(Long messagesId);

    List<Messages> getAllMessages();

}
