package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.dataclasses.Place

class LineAdapter(val list: ArrayList<Place>): RecyclerView.Adapter<LineViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler, parent, false);
        return LineViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val currentPlace = list[position]

        holder._capital.text = currentPlace.capital + "(" + currentPlace.country + ")"
        if(currentPlace.habitants < 5000)
            holder._habitantes.text = "pequeno"
        else holder._habitantes.text = "grande"
        holder._president.text = currentPlace.president
    }

}

class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val _capital: TextView
    val _habitantes: TextView
    val _president: TextView

    init {
        _capital = itemView.findViewById(R.id.txtcapital)
        _habitantes = itemView.findViewById(R.id.txthabitants)
        _president = itemView.findViewById(R.id.txtpresident)
    }

}