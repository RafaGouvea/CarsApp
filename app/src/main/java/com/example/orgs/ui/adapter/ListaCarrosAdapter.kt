package com.example.orgs.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.databinding.CarsListBinding
import com.example.orgs.extensions.formatToBrazilianReal
import com.example.orgs.extensions.loadImgView
import com.example.orgs.model.Car

class ListaCarrosAdapter(
    private val context: Context,
    cars: List<Car>,
    var onItemClicked: (car: Car) -> Unit = {}
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

    inner class ViewHolder(private val binding: CarsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var car: Car

        init {
            itemView.setOnClickListener {
                Log.i("ListaProdutosAdapter", "clicando no item")
                if (::car.isInitialized) {
                    onItemClicked(car)
                }
            }
        }

        fun vincula(car: Car) {
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
}
