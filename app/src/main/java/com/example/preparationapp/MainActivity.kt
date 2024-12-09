package com.example.preparationapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        val btnAverage = findViewById<Button>(R.id.averagebtn)

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
            } else {
                Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_SHORT).show()
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

        // average button functionality
        btnAverage.setOnClickListener {
            val average = calculateAverage()
            Log.d("MainActivity", "The average money spent is: $average")
            // Display the result in a Toast message
            Toast.makeText(this, "Average money spent: R%.2f".format(average), Toast.LENGTH_LONG).show()
        }


    }

    // Method to calculate the average of the money spent
    private fun calculateAverage(): Double {
        var totalSpent = 0.0
        var count = 0

        // Loop through the SpendingDate list and sum up the morning and afternoon values
        for (student in SpendingDate) {
            try {
                // Convert the morning and afternoon expenses to doubles
                val morningSpent = student.morning.toDoubleOrNull() ?: 0.0
                val afternoonSpent = student.afternoon.toDoubleOrNull() ?: 0.0
                totalSpent += morningSpent + afternoonSpent
                count++
            } catch (e: Exception) {
                Log.e("MainActivity", "Error parsing expense values: ${e.message}")
            }
        }

        // Return the average or 0 if there are no records
        return if (count > 0) totalSpent / count else 0.0
    }
}
