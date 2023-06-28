package com.example.orgs.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.orgs.model.Car

@Dao
interface CarDao {

    @Query("SELECT * FROM Car")
    fun getAll(): List<Car>

    @Insert
    fun insertAll(vararg cars: Car)

}
