package com.example.tpo_gym_app.pantallas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tpo_gym_app.R

class ItemEjercicio (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name : TextView = itemView.findViewById(R.id.lblName)
    val cat : TextView = itemView.findViewById(R.id.lblMuscle)
    var fav : Switch = itemView.findViewById(R.id.switch_Favoritos)
    var separator : View = itemView.findViewById(R.id.vh_separator)
}


