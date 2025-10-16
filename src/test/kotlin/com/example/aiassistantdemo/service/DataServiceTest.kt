package com.example.aiassistantdemo.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DataServiceTest {
    val sut = DataService()

    @Test
    fun `Return name of current user`() {
        val result = sut.getUserName()
        assertThat(result).isEqualTo("John Doe")
    }

    @Test
    fun `Return number of products`() {
        val result = sut.getProducts()
        assertThat(result.size).isEqualTo(4)
    }

    @Test
    fun `Return number of claims`() {
        val result = sut.getClaims()
        assertThat(result.size).isEqualTo(3)
    }
}