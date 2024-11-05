package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ImageActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the username from the intent extras
        val username = intent.getStringExtra("USERNAME")

        // Find TextView by ID and set the username
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = getString(R.string.welcome, username)

        val openNewActivityButton = findViewById<Button>(R.id.button)

        // Set an onClickListener for the button
        openNewActivityButton.setOnClickListener {
            // Create an Intent to start the new activity
            val intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)

            val openImageActivityButton = findViewById<Button>(R.id.button2)
            openImageActivityButton.setOnClickListener {
                // Create an Intent to start ImageActivity
                val intent = Intent(this, ImageActivity::class.java)
                startActivity(intent)

                val openSearchActivityButton = findViewById<Button>(R.id.button3)
                openSearchActivityButton.setOnClickListener {
                    // Create an Intent to start ImageActivity
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)



    }
}}}}
