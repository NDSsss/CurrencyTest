package com.example.currencytest

data class Check(
    val name: String,
    val currency: Currency,
    val sum: Double
)

enum class Currency {
    RUR,
    USD,
    EUR
}