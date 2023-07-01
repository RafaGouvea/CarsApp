package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.orgs.R
import com.example.orgs.databinding.ActivityDetailCarBinding
import com.example.orgs.extensions.formatToBrazilianReal
import com.example.orgs.extensions.loadImgView
import com.example.orgs.model.Car

class DetailCarActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailCarBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadProduct()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details_car, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_detail_car_edit -> {
                Log.i("Teste", "Edit")
            }
            R.id.menu_detail_car_delete -> {
                Log.i("Teste", "Delete")
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun loadProduct() {
        intent.getParcelableExtra<Car>("KEY_CAR")?.let {
            loadFields(it)
        } ?: finish()
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
