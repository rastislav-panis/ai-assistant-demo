package com.example.aiassistantdemo.service

import com.example.aiassistantdemo.model.Claim
import com.example.aiassistantdemo.model.Product
import java.time.LocalDate
import org.springframework.stereotype.Service

@Service
class DataService {

    fun getUserName(): String {
        return "John Doe"
    }

    fun getUserEmail(): String {
        return "john@doe.com"
    }

    fun getProducts(): List<Product> {
        val now = LocalDate.now()
        return listOf(
            Product(id = "1", productName = "car insurance", startDate = now.minusYears(1), endDate = null),
            Product(id = "2", productName = "house inventory insurance", startDate = now.minusYears(1), endDate = null),
            Product(id = "3", productName = "theft insurance", startDate = now.minusMonths(1), endDate = null),
            Product(id = "4", productName = "electronic insurance", startDate = now.minusMonths(2), endDate = null)
        )
    }

    fun getClaims(): List<Claim> {
        val now = LocalDate.now()
        return listOf(
            Claim(productId = "1", claimId = "1", claimDate = now.minusDays(1), note = "car accident"),
            Claim(productId = "3", claimId = "2", claimDate = now.minusDays(2), note = "theft of bike"),
            Claim(productId = "4", claimId = "3", claimDate = now.minusDays(3), note = "broken screen"),
        )
    }

}