package com.example.orgs.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.ui.adapter.ListaCarrosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListCarsActivity : AppCompatActivity(R.layout.activity_list_cars) {
    private val dao = ProductsDao()
    private val adapter = ListaCarrosAdapter(context = this, cars = dao.showCars())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecycleView()
    }

    override fun onResume() {
        super.onResume()
        adapter.refresh(dao.showCars())
        configFab()
    }

    private fun configRecycleView() {
        val recycleView: RecyclerView = findViewById(R.id.recycleView)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this)
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener{
            taskClickFab()
        }
    }

    private fun taskClickFab() {
        val intent = Intent(this, FormCarsActivity::class.java)
        startActivity(intent)
    }
}
