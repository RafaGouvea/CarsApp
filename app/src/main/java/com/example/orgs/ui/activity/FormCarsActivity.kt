package com.example.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.dao.ProductsDao
import com.example.orgs.databinding.ActivityFormCarsBinding
import com.example.orgs.model.Car
import java.math.BigDecimal

class FormCarsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormCarsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        btnSaveCar()
    }

    private fun btnSaveCar() {
        val btnRegister = binding.buttonRegister
        val productsDao = ProductsDao()
        btnRegister.setOnClickListener {
            val cars = newCar()
            productsDao.addCar(cars)
            finish()
        }
    }

    private fun newCar(): Car {
        val nameInput = binding.inputName
        val name = nameInput.text.toString()
        val modelInput = binding.inputModel
        val model = modelInput.text.toString()
        val priceInput = binding.inputPrice
        val priceText = priceInput.text.toString()
        val price =  if (priceText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceText)
        }

        return Car(
            name = name,
            modelCar = model,
            price = price
        )
    }
}