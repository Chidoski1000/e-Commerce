package com.example.demorestservice.services;

import com.example.demorestservice.entities.ChatMessage;
import com.example.demorestservice.entities.Messages;
import com.example.demorestservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatMessageService {

    ChatMessage addChatMessage(ChatMessage chatMessage);

    ChatMessage getChatMessage(Long chatMessageId);

    List<Messages> getAllMessagesFromChatMessage(Long chatMessageId);


}
