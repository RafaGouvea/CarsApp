package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.ui.adapter.ListaCarrosAdapter
import com.example.orgs.ui.models.Cars

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        recycleView.adapter = ListaCarrosAdapter(context = this, cars = listOf(
            Cars(
                "Jetta",
                "Volkswagen",
                "R$54.964,35"
            ),
            Cars(
                "Compass",
                "Jeep",
                "R$120.234,00"
            ),
        ))
        recycleView.layoutManager = LinearLayoutManager(this)

    }
}