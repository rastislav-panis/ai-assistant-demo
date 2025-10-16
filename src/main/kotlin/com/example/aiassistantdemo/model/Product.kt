package com.example.aiassistantdemo.model

import java.time.LocalDate

data class Product(
    val id: String,
    val productName: String,
    val startDate: LocalDate,
    val endDate: LocalDate?
)
