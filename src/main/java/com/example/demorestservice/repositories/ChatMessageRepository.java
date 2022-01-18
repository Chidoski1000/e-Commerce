package com.example.demorestservice.repositories;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.entities.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
