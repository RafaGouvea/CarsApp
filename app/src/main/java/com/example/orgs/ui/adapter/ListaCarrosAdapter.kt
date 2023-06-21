package com.example.orgs.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.databinding.CarsListBinding
import com.example.orgs.model.Car
import com.example.orgs.ui.activity.ListCarsActivity
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ListaCarrosAdapter(
    private val context: Context,
    cars: List<Car>
) : RecyclerView.Adapter<ListaCarrosAdapter.ViewHolder>() {

    private val cars = cars.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = CarsListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = cars[position]
        holder.vincula(car)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    fun notifyChanged(cars: List<Car>) {
        this.cars.clear()
        this.cars.addAll(cars)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: CarsListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun vincula(car: Car) {
            val name = binding.carsListName
            name.text = car.name

            val model = binding.carsListModel
            model.text = car.modelCar

            val price = binding.carsListPrice
            val realPrice = formatToReal(car.price)
            price.text = realPrice
        }

        private fun formatToReal(price: BigDecimal): String {
            val formater = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return formater.format(price)
        }
    }
}
