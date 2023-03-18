package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.LineAdapter
import com.example.recyclerview.dataclasses.Place

class MainActivity : AppCompatActivity() {

    private lateinit var myList: ArrayList<Place>
    private lateinit var recycler_view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myList = ArrayList<Place>()
        for(i in 0..500){
            myList.add(Place("Country $i", i*500, "Capital $i", "President $i"))
        }
        recycler_view = findViewById<RecyclerView>(R.id.recView)
        recycler_view.adapter = LineAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    fun insert(view: View){
        myList.add(0, Place("Country XXX", 999, "Capital XXX", "President XXX"))
        recycler_view.adapter?.notifyDataSetChanged()
    }
}