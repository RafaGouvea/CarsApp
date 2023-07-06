package com.example.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.database.AppDataBase
import com.example.orgs.database.dao.CarDao
import com.example.orgs.databinding.ActivityFormCarsBinding
import com.example.orgs.extensions.loadImgView
import com.example.orgs.model.Car
import com.example.orgs.ui.dialog.FormularioImgDialog
import java.math.BigDecimal

class FormCarsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFormCarsBinding.inflate(layoutInflater) }
    private var url: String? = null
    private var carId = 0
    private val carDao: CarDao by lazy {
        val db = AppDataBase.instance(this)
        db.carDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar Produto"
        btnAddImageCar()
        btnSaveCar()
        editCar()
    }

    override fun onResume() {
        super.onResume()
        title = "Editar Produto"
        carDao.searchId(carId)?.let {
            loadFilds(it)
        }
    }

    private fun loadFilds(car: Car) {
        url = car.imgItem
        binding.addImgCar.loadImgView(car.imgItem)
        binding.inputName.setText(car.name)
        binding.inputModel.setText(car.modelCar)
        binding.inputPrice.setText(car.price.toPlainString())
    }

    private fun editCar() {
        carId = intent.getIntExtra("KEY_CAR_ID", 0)
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

        btnRegister.setOnClickListener {
            val cars = newCar()
            carDao.save(cars)
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