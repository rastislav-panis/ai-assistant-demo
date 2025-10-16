package com.example.aiassistantdemo.service

import org.springframework.stereotype.Component

@Component
class ChatService() {
    fun chat(userMessage: String): String? {
        return "hello from chat service"
    }
}