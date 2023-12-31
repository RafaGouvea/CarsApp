package com.example.orgs.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.databinding.CarsListBinding
import com.example.orgs.extensions.formatToBrazilianReal
import com.example.orgs.extensions.loadImgView
import com.example.orgs.model.Car

class ListaCarrosAdapter(
    private val context: Context,
    cars: List<Car> = emptyList(),
    var onItemClicked: (car: Car) -> Unit = {}
) : RecyclerView.Adapter<ListaCarrosAdapter.ViewHolder>() {

    private val cars = cars.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = CarsListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: CarsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(car: Car) {
            binding.root.setOnClickListener {
                onItemClicked(car)
            }

            val name = binding.carsListName
            name.text = car.name
            val model = binding.carsListModel
            model.text = car.modelCar
            val price = binding.carsListPrice
            val realBrazilianPrice: String = car.price.formatToBrazilianReal()
            price.text = realBrazilianPrice
            binding.imageView.loadImgView(car.imgItem)
        }
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

    inner class filters(){
        fun sortByCarNameAscending(){
            cars.sortBy { it.name }
            notifyDataSetChanged()
        }
        fun sortByCarNameDescending(){
            cars.sortByDescending { it.name }
            notifyDataSetChanged()
        }

        fun sortByModelCarAscending() {
            cars.sortBy { it.modelCar }
            notifyDataSetChanged()
        }

        fun sortByModelCarDescending() {
            cars.sortByDescending { it.modelCar }
            notifyDataSetChanged()
        }

        fun sortByAscedingCarPrice() {
            cars.sortBy { it.price }
            notifyDataSetChanged()
        }

        fun sortByDescedingCarPrice() {
            cars.sortByDescending { it.price }
            notifyDataSetChanged()
        }
    }
}
