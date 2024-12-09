package com.example.preparationapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.util.Log

class Display: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.displayrecyclerview) //Set the content view to the recyclerview' layout
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =
            ExamAdapter(MainActivity.SpendingDate)// // The adapter binds the data from 'moduleList' to the items displayed in the RecyclerViewSep

        // Reference the button and set its click listener
        val backButton = findViewById<Button>(R.id.btnBack)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))


        }
    }
}
