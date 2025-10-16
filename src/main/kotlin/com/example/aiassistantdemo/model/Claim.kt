package com.example.aiassistantdemo.model

import java.time.LocalDate

data class Claim(
    val productId: String,
    val claimId: String, val claimDate: LocalDate,
    val note: String
) {

}
