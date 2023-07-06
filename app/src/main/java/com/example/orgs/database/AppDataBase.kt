package com.example.orgs.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.orgs.database.dao.CarDao
import com.example.orgs.model.Car
import kotlin.math.log

@Database(entities = [Car::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun carDao(): CarDao

    companion object {

        @Volatile
        private lateinit var db: AppDataBase

        fun instance(context: Context): AppDataBase {
            if (::db.isInitialized) return db
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "cars.db"
            ).allowMainThreadQueries()
                .build().also {
                    Log.e("###", "teste")
                    db = it
                }
        }
    }
}
