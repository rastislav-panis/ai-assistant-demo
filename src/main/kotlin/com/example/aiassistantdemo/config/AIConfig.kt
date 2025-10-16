package com.example.aiassistantdemo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class AIConfig(@Value("\${langchain4j.open-ai.chat-model.api-key}") private val oAiApiKey: String) {


}