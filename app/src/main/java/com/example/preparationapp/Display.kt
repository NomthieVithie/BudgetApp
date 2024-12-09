package com.example.preparationapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent

class Display : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.displayrecyclerview) // Set the content view to the recyclerview layout

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ExamAdapter(MainActivity.SpendingDate) // The adapter binds the data from 'SpendingDate'

        // Reference the button and set its click listener for going back to MainActivity
        val backButton = findViewById<Button>(R.id.btnBack)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Call function to get the day with the highest expense
        val highestExpenseDay = getDayWithHighestExpense()

        // Display the result in a Toast or update the UI accordingly
        if (highestExpenseDay != null) {
            val (day, expense) = highestExpenseDay
            Toast.makeText(this, "Day with highest expense: $day - R$expense", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "No data available to calculate highest expense.", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to calculate the day with the highest total expense
    private fun getDayWithHighestExpense(): Pair<String, Double>? {
        var highestExpense = 0.0
        var highestExpenseDay: String? = null

        // Loop through the SpendingDate list to calculate total expenses for each day
        for (student in MainActivity.SpendingDate) {
            val morningSpent = student.morning.toDoubleOrNull() ?: 0.0
            val afternoonSpent = student.afternoon.toDoubleOrNull() ?: 0.0
            val totalSpentForDay = morningSpent + afternoonSpent

            // Update highestExpense and highestExpenseDay if this day's expense is higher
            if (totalSpentForDay > highestExpense) {
                highestExpense = totalSpentForDay
                highestExpenseDay = student.date
            }
        }

        // Return the result as a Pair (date, totalSpent) or null if no data
        return if (highestExpenseDay != null) Pair(highestExpenseDay, highestExpense) else null
    }
}
