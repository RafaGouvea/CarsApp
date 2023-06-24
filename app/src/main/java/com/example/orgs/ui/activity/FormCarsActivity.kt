package com.example.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.databinding.ActivityFormCarsBinding
import com.example.orgs.databinding.FormImagemBinding
import com.example.orgs.model.Car
import java.math.BigDecimal

class FormCarsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormCarsBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        btnSaveCar()
        btnAddImageCar()
    }

    private fun btnAddImageCar() {
        binding.addImgCar.setOnClickListener {
            val bindingImageCar = FormImagemBinding.inflate(layoutInflater)
            bindingImageCar.buttonAddImagem.setOnClickListener {
                url = bindingImageCar.editTextUrl.text.toString()
                bindingImageCar.imgForms.load(url)
            }

            AlertDialog.Builder(this)
                .setView(bindingImageCar.root)
                .setPositiveButton("Confirm") { _, _ ->
                    binding.addImgCar.load(url)

                }
                .setNegativeButton("Cancel") { _, _ ->

                }
                .show()
        }
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
        val price = if (priceText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceText)
        }

        return Car(
            name = name,
            modelCar = model,
            price = price,
            imgItem = url
        )
    }
}