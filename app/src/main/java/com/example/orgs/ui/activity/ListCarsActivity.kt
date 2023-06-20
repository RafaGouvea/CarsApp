package com.example.orgs.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.databinding.ActivityListCarsBinding
import com.example.orgs.ui.adapter.ListaCarrosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyChanged(dao.showCars())
        navigateFormularioCarros()
    }

    private fun initRecycleView() {
        val recycleView = binding.recycleView
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this)
    }

    private fun navigateFormularioCarros() {
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
