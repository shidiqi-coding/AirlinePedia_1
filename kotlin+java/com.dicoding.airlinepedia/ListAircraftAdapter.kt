package com.dicoding.airlinepedia

//import android.os.Bundle

import android.view.ViewGroup
import android.view.View
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.recyclerviewapp.aircraft


//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat

class ListAircraftAdapter(private val listAirline: ArrayList<aircraft>): RecyclerView.Adapter<ListAircraftAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        i: Int
    ):ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_airline,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder:ListViewHolder, position: Int) {
        val(name, description, photo) =listAirline[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailAirlineActivity::class.java)
            intentDetail.putExtra("key_airline", listAirline[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
    override fun getItemCount(): Int = listAirline.size


    class ListViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName:  TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription : TextView = itemView.findViewById(R.id.tv_item_description)


    }
}
