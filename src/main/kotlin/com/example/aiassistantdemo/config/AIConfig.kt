package com.example.aiassistantdemo.config

import com.example.aiassistantdemo.service.Assistant
import com.example.aiassistantdemo.service.ToolsDataService
import dev.langchain4j.memory.chat.MessageWindowChatMemory
import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.openai.OpenAiChatModel
import dev.langchain4j.model.openai.OpenAiChatModelName
import dev.langchain4j.service.AiServices
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AIConfig(
    @Value("\${langchain4j.open-ai.chat-model.api-key}") private val oAiApiKey: String,
    val toolsDataService: ToolsDataService
) {

    @Bean
    fun assistant(chatModel: ChatModel): Assistant {
        return AiServices.builder(Assistant::class.java)
            .chatModel(chatModel)
            .tools(toolsDataService)
            .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
            .build()
    }

    @Bean
    fun chatModel(): OpenAiChatModel {
        return OpenAiChatModel.builder()
            .apiKey(oAiApiKey)
            .modelName(OpenAiChatModelName.GPT_5_MINI)
            .logRequests(true)
            .logResponses(true)
            .build()
    }
}