package com.example.demorestservice.services;

import com.example.demorestservice.models.ChatMessage;
import com.example.demorestservice.models.Messages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatMessageService {

    ChatMessage addChatMessage(ChatMessage chatMessage);

    ChatMessage getChatMessage(Long chatMessageId);

    List<Messages> getAllMessagesFromChatMessage(Long chatMessageId);


}
