package com.example.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.database.AppDataBase
import com.example.orgs.databinding.ActivityFormCarsBinding
import com.example.orgs.extensions.loadImgView
import com.example.orgs.model.Car
import com.example.orgs.ui.dialog.FormularioImgDialog
import java.math.BigDecimal

class FormCarsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFormCarsBinding.inflate(layoutInflater) }
    private var url: String? = null
    private var carId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar Produto"
        btnAddImageCar()
        btnSaveCar()
        editCar()

    }

    private fun editCar() {
        intent.getParcelableExtra<Car>("KEY_CAR")?.let {
            title = "Editar Produto"
            url = it.imgItem
            carId = it.id
            binding.addImgCar.loadImgView(it.imgItem)
            binding.inputName.setText(it.name)
            binding.inputModel.setText(it.modelCar)
            binding.inputPrice.setText(it.price.toPlainString())
        }
    }

    private fun btnAddImageCar() {
        binding.addImgCar.setOnClickListener {
            FormularioImgDialog(this).show(url) {
                url = it
                binding.addImgCar.loadImgView(url)
            }
        }
    }

    private fun btnSaveCar() {
        val btnRegister = binding.buttonRegister
        val db = AppDataBase.instance(this)
        val carsDao = db.carDao()
        btnRegister.setOnClickListener {
            val cars = newCar()
            if(carId > 0){
                carsDao.update(cars)
            }else {
                carsDao.save(cars)
            }
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
            id = carId,
            name = name,
            modelCar = model,
            price = price,
            imgItem = url
        )
    }
}