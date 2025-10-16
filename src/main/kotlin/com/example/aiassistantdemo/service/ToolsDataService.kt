package com.example.aiassistantdemo.service

import com.example.aiassistantdemo.model.Claim
import com.example.aiassistantdemo.model.Product
import dev.langchain4j.agent.tool.Tool
import org.springframework.stereotype.Service

@Service
class ToolsDataService(val dataService: DataService) {

    @Tool("Get user name")
    fun getUserName(): String {
        return dataService.getUserName()
    }

    @Tool("Get user products")
    fun getUserProducts(): List<Product> {
        return dataService.getProducts()
    }

    @Tool("Get user claims")
    fun getUserClaims(): List<Claim> {
        return dataService.getClaims()
    }
}
