package com.example.preparationapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)  // Set splash screen layout

        // Initialize the button
        val btnGoToMain = findViewById<Button>(R.id.btnMain)
        val btnExit=findViewById<Button>(R.id.btnExit)


        // Navigate to MainActivity
        btnGoToMain.setOnClickListener {
            navigateToMainScreen()



        }

        // exit button
        val exitButton = findViewById<Button>(R.id.btnExit)
        exitButton.setOnClickListener {
            finish()
        }


    }

    // Method to navigate to MainActivity
    private fun navigateToMainScreen() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()  // Finish the SplashActivity so the user cannot return to it by pressing Back
    }
}
