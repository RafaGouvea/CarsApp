package com.example.orgs.model

import java.math.BigDecimal

data class Car(
    val name: String,
    val modelCar: String,
    val price: BigDecimal,
    val imgItem: String? = null
)


