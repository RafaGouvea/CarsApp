package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.model.Car
import com.google.android.material.textfield.TextInputEditText

class FormCarsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cars)
        btnAddCar()
    }

    private fun btnAddCar() {
        val btnRegister = findViewById<Button>(R.id.btn_register)
        val productsDao = ProductsDao()
        btnRegister.setOnClickListener {
            val cars = newCar()
            productsDao.addCar(cars)
            finish()
        }
    }

    private fun newCar(): Car {
        val name = findViewById<TextInputEditText>(R.id.input_name)
        val nameTxt = name.text.toString()
        val model = findViewById<TextInputEditText>(R.id.input_model)
        val modelTxt = model.text.toString()
        val price = findViewById<TextInputEditText>(R.id.input_price)
        val priceTxt = price.text.toString()

        return Car(
            name = nameTxt,
            modelCar = modelTxt,
            price = priceTxt
        )
    }
}