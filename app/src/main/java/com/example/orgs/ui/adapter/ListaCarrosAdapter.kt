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

class ListaCarrosAdapter(
    private val context: Context,
    cars: List<Car>
) : RecyclerView.Adapter<ListaCarrosAdapter.ViewHolder>() {

    private val cars = cars.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CarsListBinding.inflate(LayoutInflater.from(context), parent, false)

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

    class ViewHolder(binding: CarsListBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.carsListName
        val model = binding.carsListModel
        val price = binding.carsListPrice

        fun vincula(car: Car) {
            name.text = car.name
            model.text = car.modelCar
            price.text = car.price
        }
    }
}
