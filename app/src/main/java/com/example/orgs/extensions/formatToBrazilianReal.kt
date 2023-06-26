package com.example.orgs.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.formatToBrazilianReal(): String {
    val formater = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return formater.format(this)
}