package com.example.orgs.database.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.orgs.model.Car

@Dao
interface CarDao {

    @Query("SELECT * FROM Car")
    fun getAll(): List<Car>

    @Insert
    fun save(vararg cars: Car)

    @Delete
    fun delete(vararg cars: Car)

    @Update
    fun update(vararg cars: Car)

}
