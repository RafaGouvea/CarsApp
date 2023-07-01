package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orgs.database.AppDataBase
import com.example.orgs.databinding.ActivityListCarsBinding
import com.example.orgs.model.Car
import com.example.orgs.ui.adapter.ListaCarrosAdapter

class ListCarsActivity : AppCompatActivity() {

    private val binding by lazy {ActivityListCarsBinding.inflate(layoutInflater)}
    private val adapter = ListaCarrosAdapter(context = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycleView()
        navigateFormsCars()
    }


    override fun onResume() {
        super.onResume()
        val db = AppDataBase.instance(this)
        val carsDao = db.carDao()
        adapter.notifyChanged(carsDao.getAll())
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
