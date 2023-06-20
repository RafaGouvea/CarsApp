package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.databinding.ActivityFormCarsBinding
import com.example.orgs.model.Car
import com.google.android.material.textfield.TextInputEditText

class FormCarsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormCarsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        btnAddCar()
    }

    private fun btnAddCar() {
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
        val price = priceInput.text.toString()

        return Car(
            name = name,
            modelCar = model,
            price = price
        )
    }
}