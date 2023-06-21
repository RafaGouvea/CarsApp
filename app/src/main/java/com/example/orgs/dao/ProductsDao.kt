package com.example.orgs.dao

import com.example.orgs.model.Car
import java.math.BigDecimal

class ProductsDao {

    fun addCar(car: Car) {
        cars.add(car)
    }

    fun showCars(): List<Car> {
        return cars.toList()
    }

    companion object {
        private val cars = mutableListOf<Car>(
            Car(
                name = "Jetta",
                modelCar = "Volkswagem",
                price = BigDecimal("60.390")
            )
        )
    }
}
