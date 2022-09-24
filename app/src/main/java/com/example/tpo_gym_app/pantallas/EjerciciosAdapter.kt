package com.example.tpo_gym_app.pantallas

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tpo_gym_app.R

import com.example.tpo_gym_app.objetos.Category
import com.example.tpo_gym_app.objetos.Exercise
import com.example.tpo_gym_app.objetos.Muscle
import java.io.Serializable
import kotlin.math.log

class EjerciciosAdapter(var ejercicios: MutableList<Exercise>,
                        var categorias: MutableList<Category>,
                        var musculos: MutableList<Muscle>,
                        context: Context): RecyclerView.Adapter<ItemEjercicio>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemEjercicio {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_ejercicio,parent,false)
        return ItemEjercicio(view)
    }

    override fun onBindViewHolder(holder: ItemEjercicio, position: Int) {
        holder.name.text = ejercicios[position].name
        val catId = ejercicios[position].category
        for(cat in categorias)
            if (cat.id == catId){
                holder.cat.text = cat.name
                break;
            }
        if (position == (itemCount - 1)) {
            holder.separator.visibility = View.INVISIBLE
        } else {
            holder.separator.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        Log.d("debug","ejercicios.size: " + ejercicios.size)
        return ejercicios.size
    }

    fun update(new_ejercicios: MutableList<Exercise>,
               new_categorias: MutableList<Category>,
               new_musculos: MutableList<Muscle>){
        ejercicios = new_ejercicios
        categorias = new_categorias
        musculos = new_musculos
        this.notifyDataSetChanged()
    }

}