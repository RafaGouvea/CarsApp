package com.example.orgs.dao

import com.example.orgs.model.Car

class ProductsDao {

    fun addCar(car: Car){
        cars.add(car)
    }

    fun showCars(): List<Car>{
        return cars.toList()
    }

    companion object {
        private val cars = mutableListOf<Car>()
    }


}