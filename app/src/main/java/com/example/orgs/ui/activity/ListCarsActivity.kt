package com.example.orgs.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.orgs.dao.ProductsDao
import com.example.orgs.database.AppDataBase
import com.example.orgs.databinding.ActivityListCarsBinding
import com.example.orgs.model.Car
import com.example.orgs.ui.adapter.ListaCarrosAdapter
import java.math.BigDecimal

class ListCarsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListCarsBinding.inflate(layoutInflater)
    }
    private val dao = ProductsDao()
    private val adapter = ListaCarrosAdapter(context = this, cars = dao.showCars())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycleView()
        navigateFormsCars()


        val db = Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "cars.db"
        ).allowMainThreadQueries()
            .build()
        val carsDao = db.carDao()
        carsDao.insertAll(
            Car(
                name = "teste 1",
                modelCar = "teste 1",
                price = BigDecimal("10")
            )
        )
        adapter.notifyChanged(carsDao.getAll())
    }


    override fun onResume() {
        super.onResume()
       // adapter.notifyChanged(dao.showCars())
    }

    private fun initRecycleView() {
        val recycleView = binding.recycleView
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
        adapter.onItemClicked = {
            val intent = Intent(this, DetailCarActivity::class.java).apply {
                putExtra("KEY_CAR", it)
            }
            startActivity(intent)
        }
    }

    private fun navigateFormsCars() {
        val fab = binding.floatingActionButton
        fab.setOnClickListener {
            taskFab()
        }
    }

    private fun taskFab() {
        val intent = Intent(this, FormCarsActivity::class.java)
        startActivity(intent)
    }
}
