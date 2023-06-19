package com.example.orgs.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.ui.adapter.ListaCarrosAdapter
import com.example.orgs.model.Car
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val dao = ProductsDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
        initView()
        navigateFormularioCarros()

    }

    private fun initView() {
        val recycleView: RecyclerView = findViewById(R.id.recycleView)
        recycleView.adapter = ListaCarrosAdapter(context = this, cars = dao.showCars())
        recycleView.layoutManager = LinearLayoutManager(this)
    }

    private fun navigateFormularioCarros() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener{
            val intent = Intent(this, FormularioCarrosActivity::class.java)
            startActivity(intent)
        }
    }
}
