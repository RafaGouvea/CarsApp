package com.example.orgs.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Entity
@Parcelize
data class Car(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    val name: String,
    val modelCar: String,
    val price: BigDecimal,
    val imgItem: String? = null
) : Parcelable


