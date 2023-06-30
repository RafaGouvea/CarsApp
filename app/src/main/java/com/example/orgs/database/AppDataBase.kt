package com.example.orgs.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.orgs.database.dao.CarDao
import com.example.orgs.model.Car

@Database(entities = [Car::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun carDao(): CarDao

    companion object {
        fun instance (context: Context) : AppDataBase {
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "cars.db"
            ).allowMainThreadQueries()
                .build()
        }
    }

}
