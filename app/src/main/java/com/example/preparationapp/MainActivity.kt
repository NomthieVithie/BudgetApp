package com.example.preparationapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.preparationapp.ui.theme.PreparationAppTheme

class MainActivity : ComponentActivity() {

    companion object {

        //Companion object to store a mutable list of Student objects
        val SpendingDate = mutableListOf<Student>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_data)

        //references to the EditText views for user input
        val tdate = findViewById<EditText>(R.id.edate)
        val tmorning = findViewById<EditText>(R.id.emorning)
        val tafternoon = findViewById<EditText>(R.id.eafternoon)
        val tnotes = findViewById<EditText>(R.id.enotes)

        // references to the buttons for actions
        val btnSave = findViewById<Button>(R.id.submitbtn)
        val btnClear = findViewById<Button>(R.id.clearbtn)
        val btnShow = findViewById<Button>(R.id.showdata)

        //when save button is clicked
        btnSave.setOnClickListener {

            val date = tdate.text.toString()
            val morning = tmorning.text.toString()
            val afternoon = tafternoon.text.toString()
            val notes=tnotes.text.toString()


            //check if input is not blank
            if (date.isNotBlank() && morning.isNotBlank() && afternoon.isNotBlank() && notes.isNotBlank()) {
                //lets insert the date into the list
                SpendingDate.add(Student(date, morning, afternoon, notes))
                tdate.text.clear() //clears input field after a successful save
                tmorning.text.clear() //clear the morning textview
                tafternoon.text.clear()//clear the afternoon textview
                tnotes.text.clear()//clear the notes textview


            }


        }
        btnClear.setOnClickListener{ //clear button functionality
            tdate.text.clear()
            tmorning.text.clear()
            tafternoon.text.clear()
            tnotes.text.clear()
    }

        btnShow.setOnClickListener {
            //calling  the second screen to show the data
            //debug the code
            Log.d("MainActivity","View all once button is clicked")
            startActivity(Intent(this,Display ::class.java))


        }

    }
}

