package com.example.aiassistantdemo.service

import dev.langchain4j.agent.tool.Tool
import org.springframework.stereotype.Service

@Service
class ToolsDataService(val dataService: DataService) {

    @Tool("Get user name")
    fun getUserName(): String {
        return dataService.getUserName()
    }
}
