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
    private val cars: List<Car>
) : RecyclerView.Adapter<ListaCarrosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produtos_carros, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = cars[position]
        holder.vincula(car)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        fun vincula(car: Car) {

            val name = itemView.findViewById<TextView>(R.id.tv_name)
            val model = itemView.findViewById<TextView>(R.id.tv_model)
            val value = itemView.findViewById<TextView>(R.id.tv_value)

            name.text = car.name
            model.text = car.modelCar
            value.text = car.price

        }

    }

}
