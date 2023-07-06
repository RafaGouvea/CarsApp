package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orgs.R
import com.example.orgs.database.AppDataBase
import com.example.orgs.databinding.ActivityListCarsBinding
import com.example.orgs.ui.adapter.ListaCarrosAdapter

class ListCarsActivity : AppCompatActivity() {

    private val binding by lazy {ActivityListCarsBinding.inflate(layoutInflater)}
    private val adapter = ListaCarrosAdapter(context = this)
    private val carDao by lazy { AppDataBase.instance(this).carDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycleView()
        navigateFormsCars()
    }


    override fun onResume() {
        super.onResume()
        adapter.notifyChanged(carDao.getAll())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list_cars_filters, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_filter_car_name_ascending -> {
                adapter.filters().sortByCarNameAscending()
            }
            R.id.menu_filter_car_name_descending -> {
                adapter.filters().sortByCarNameDescending()
            }
            R.id.menu_filter_model_car_ascending -> {
                adapter.filters().sortByModelCarAscending()
            }
            R.id.menu_filter_model_car_desccending -> {
                adapter.filters().sortByModelCarDescending()
            }
            R.id.menu_filter_car_price_ascending -> {
                adapter.filters().sortByAscedingCarPrice()
            }
            R.id.menu_filter_car_price_descending -> {
                adapter.filters().sortByDescedingCarPrice()
            }
            R.id.menu_filter_no_filter -> {
               adapter.notifyChanged(carDao.getAll())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initRecycleView() {
        val recycleView = binding.recycleView
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
        adapter.onItemClicked = {
            val intent = Intent(this, DetailCarActivity::class.java).apply {
                putExtra("KEY_CAR_ID", it.id)
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
