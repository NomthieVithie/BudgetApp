package com.example.preparationapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.preparationapp.ui.theme.PreparationAppTheme

class MainActivity : ComponentActivity() {

    companion object {
        // Companion object to store a mutable list of Student objects
        val SpendingDate = mutableListOf<Student>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_data)

        // references to the EditText views for user input
        val tdate = findViewById<EditText>(R.id.edate)
        val tmorning = findViewById<EditText>(R.id.emorning)
        val tafternoon = findViewById<EditText>(R.id.eafternoon)
        val tnotes = findViewById<EditText>(R.id.enotes)

        // references to the buttons for actions
        val btnSave = findViewById<Button>(R.id.submitbtn)
        val btnClear = findViewById<Button>(R.id.clearbtn)
        val btnShow = findViewById<Button>(R.id.showdata)
        val btnAverage = findViewById<Button>(R.id.averagebtn)  // Fix variable name here

        // when save button is clicked
        btnSave.setOnClickListener {
            val date = tdate.text.toString()
            val morning = tmorning.text.toString()
            val afternoon = tafternoon.text.toString()
            val notes = tnotes.text.toString()

            // check if input is not blank
            if (date.isNotBlank() && morning.isNotBlank() && afternoon.isNotBlank() && notes.isNotBlank()) {
                // lets insert the data into the list
                SpendingDate.add(Student(date, morning, afternoon, notes))
                tdate.text.clear()  // clears input field after a successful save
                tmorning.text.clear()  // clear the morning textview
                tafternoon.text.clear()  // clear the afternoon textview
                tnotes.text.clear()  // clear the notes textview
            }
        }

        // clear button functionality
        btnClear.setOnClickListener {
            tdate.text.clear()
            tmorning.text.clear()
            tafternoon.text.clear()
            tnotes.text.clear()
        }

        // show button functionality
        btnShow.setOnClickListener {
            // calling the second screen to show the data
            Log.d("MainActivity", "View all once button is clicked")
            startActivity(Intent(this, Display::class.java))
        }

        // Average button functionality
        btnAverage.setOnClickListener {
            val averageExpenses = calculateAverageExpenses()
            if (averageExpenses != null) {
                // Display the average expenses
                Log.d("MainActivity", "Average expenses per day: $averageExpenses")
            } else {
                Log.d("MainActivity", "No expenses data found to calculate average")
            }
        }
    }

    private fun calculateAverageExpenses(): Double? {
        if (SpendingDate.isEmpty()) {
            return null
        }

        val totalExpenses = SpendingDate.sumByDouble {
            it.morning.toDouble() + it.afternoon.toDouble()
        }

        val averageExpenses = totalExpenses / SpendingDate.size
        return averageExpenses
    }
}
