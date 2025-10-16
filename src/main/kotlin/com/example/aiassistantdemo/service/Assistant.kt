package com.example.aiassistantdemo.service

import dev.langchain4j.service.SystemMessage

interface Assistant {

    @SystemMessage("You are an assistant specialized in insurance products and product claims. " +
            "Provide accurate, clear, and helpful information related to insurance policies, coverage, and claims processes.")
    fun chat(message: String): String
}
