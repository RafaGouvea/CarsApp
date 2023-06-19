package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.model.Car
import com.google.android.material.textfield.TextInputEditText

class FormularioCarrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_carros)

        btnAddCar()


    }

    private fun btnAddCar() {
        val btnRegister = findViewById<Button>(R.id.btn_register)
        btnRegister.setOnClickListener {
            val name = findViewById<TextInputEditText>(R.id.input_name)
            val nameTxt = name.text.toString()
            val model = findViewById<TextInputEditText>(R.id.input_model)
            val modelTxt = model.text.toString()
            val price = findViewById<TextInputEditText>(R.id.input_price)
            val priceTxt = price.text.toString()

            val cars = Car(
                name = nameTxt,
                modelCar = modelTxt,
                price = priceTxt
            )

            val productsDao = ProductsDao()
            productsDao.addCar(cars)
            Log.i("###", "btnAddCar: ${productsDao.showCars()}")
            finish()
        }
    }
}