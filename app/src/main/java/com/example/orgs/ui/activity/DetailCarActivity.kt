package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.orgs.R
import com.example.orgs.database.AppDataBase
import com.example.orgs.database.dao.CarDao
import com.example.orgs.databinding.ActivityDetailCarBinding
import com.example.orgs.extensions.formatToBrazilianReal
import com.example.orgs.extensions.loadImgView
import com.example.orgs.model.Car

class DetailCarActivity : AppCompatActivity() {

    private var carsId: Int = 0
    private var cars: Car? = null
    private val binding by lazy { ActivityDetailCarBinding.inflate(layoutInflater) }
    private val carDao by lazy { AppDataBase.instance(this).carDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadProduct()
    }

    override fun onResume() {
        super.onResume()
        cars = carDao.searchId(carsId)
        cars?.let {
            loadFields(it)
        } ?: finish()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details_car, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_detail_car_edit -> {
                val intent = Intent(this, FormCarsActivity::class.java).apply {
                    putExtra("KEY_CAR_ID", carsId)
                }
                startActivity(intent)
            }

            R.id.menu_detail_car_delete -> {
                cars?.let { carDao.delete(it) }
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadProduct() {
        carsId = intent.getIntExtra("KEY_CAR_ID", 0)
    }

    private fun loadFields(car: Car) {
        with(binding) {
            this.detailCarImageView.loadImgView(car.imgItem)
            this.detailCarTvPrice.text = car.price.formatToBrazilianReal()
            this.detailCarTvName.text = car.name
            this.detailCarTvCarModel.text = car.modelCar
        }
    }
}
