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


        val username = intent.getStringExtra("USERNAME")


        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = getString(R.string.welcome, username)

        val openNewActivityButton = findViewById<Button>(R.id.button)


        openNewActivityButton.setOnClickListener {

            val intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)
        }
            val openImageActivityButton = findViewById<Button>(R.id.button2)

            openImageActivityButton.setOnClickListener {

                val intent = Intent(this, ImageActivity::class.java)
                startActivity(intent)
            }
                val openSearchActivityButton = findViewById<Button>(R.id.button3)

                openSearchActivityButton.setOnClickListener {

                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)



    }
        val openListActivityButton = findViewById<Button>(R.id.button4)

        openListActivityButton.setOnClickListener {

            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)



        }
}}
