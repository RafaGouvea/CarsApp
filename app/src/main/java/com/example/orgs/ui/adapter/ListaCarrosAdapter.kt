package com.example.orgs.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Car

class ListaCarrosAdapter(
    private val context: Context,
    cars: List<Car>
) : RecyclerView.Adapter<ListaCarrosAdapter.ViewHolder>() {

    private val cars = cars.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.cars_list, parent, false)
        return ViewHolder(view)
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

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        fun vincula(car: Car) {
            val name = itemView.findViewById<TextView>(R.id.cars_list_name)
            val model = itemView.findViewById<TextView>(R.id.cars_list_model)
            val value = itemView.findViewById<TextView>(R.id.cars_list_price)
            name.text = car.name
            model.text = car.modelCar
            value.text = car.price

        }

    }

}
