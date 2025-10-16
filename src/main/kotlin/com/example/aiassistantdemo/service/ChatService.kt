package com.example.aiassistantdemo.service

import org.checkerframework.checker.units.qual.A
import org.springframework.stereotype.Component

@Component
class ChatService(
    val assistant: Assistant
) {
    fun chat(userMessage: String): String? {
        return assistant.chat(userMessage)
    }
}