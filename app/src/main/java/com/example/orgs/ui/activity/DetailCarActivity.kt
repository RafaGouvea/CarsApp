package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    private fun loadProduct() {
        intent.getParcelableExtra<Car>("key")?.let {
            loadFields(it)
        } ?: finish()
    }

    private fun loadFields(car: Car) {

        with(binding){
            this.detailCarImageView.loadImgView(car.imgItem)
            this.detailCarTvPrice.text = car.price.formatToBrazilianReal()
            this.detailCarTvName.text = car.name
            this.detailCarTvCarModel.text = car.modelCar
        }

    }


}