package com.example.orgs.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class Car(
    val name: String,
    val modelCar: String,
    val price: BigDecimal,
    val imgItem: String? = null
) : Parcelable


