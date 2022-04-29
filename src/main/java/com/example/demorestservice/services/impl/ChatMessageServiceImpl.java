package com.example.demorestservice.services.impl;

import com.example.demorestservice.models.ChatMessage;
import com.example.demorestservice.models.Messages;
import com.example.demorestservice.repositories.ChatMessageRepository;
import com.example.demorestservice.services.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage addChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    @Override
    public ChatMessage getChatMessage(Long chatMessageId) {
        Optional<ChatMessage> chat = chatMessageRepository.findById(chatMessageId);
        return chat.orElse(null);
    }

    @Override
    public List<Messages> getAllMessagesFromChatMessage(Long chatMessageId) {
        ChatMessage chatMessage = getChatMessage(chatMessageId);
        return chatMessage.getMessages();
    }
}
