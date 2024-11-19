package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Hardcoded correct username and password for this example

    private val correctPassword = "123"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Find views by ID
        val usernameEditText = findViewById<EditText>(R.id.editTextLogin)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val errorTextView = findViewById<TextView>(R.id.errorTextView)

        // Handle login button click
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if the username and password are correct
            if ( password == correctPassword) {
                // Credentials are correct, navigate to MainActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
                finish() // Close LoginActivity so user cannot go back
            } else {
                Toast.makeText(this, "Nieprawidłowa nazwa użytkownika lub hasło", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
