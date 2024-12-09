package com.example.preparationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Display: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.displayrecyclerview) //Set the content view to the recyclerview' layout
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter = ExamAdapter(MainActivity.SpendingDate)// // The adapter binds the data from 'moduleList' to the items displayed in the RecyclerView
    }
}