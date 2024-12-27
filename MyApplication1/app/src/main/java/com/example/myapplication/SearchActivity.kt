package com.example.myapplication

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search) // Replace with your actual layout name

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get references to the UI elements
        val phoneEditText = findViewById<EditText>(R.id.PhoneEdit)
        val searchEditText = findViewById<EditText>(R.id.searchedit)
        val linkEditText = findViewById<EditText>(R.id.linkedit)
        val locationEditText = findViewById<EditText>(R.id.locationSearch)

        val phoneButton = findViewById<Button>(R.id.Phonebtn)
        val searchButton = findViewById<Button>(R.id.searchbtn)
        val linkButton = findViewById<Button>(R.id.linkbtn)
        val locationButton = findViewById<Button>(R.id.locationBTN)

        // Phone button click listener
        phoneButton.setOnClickListener {
            val phoneNumber = phoneEditText.text.toString()
            if (phoneNumber.length >= 9 && phoneNumber.isDigitsOnly()) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.phonewalid), Toast.LENGTH_SHORT).show()
            }
            phoneEditText.text.clear()
        }

        // Search button click listener
        searchButton.setOnClickListener {
            val searchValue = searchEditText.text.toString()
            if (searchValue.isNotBlank()) {
                val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                    putExtra(SearchManager.QUERY, searchValue)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.searchID), Toast.LENGTH_SHORT).show()
            }
            searchEditText.text.clear()
        }

        // Link button click listener
        linkButton.setOnClickListener {
            val url = linkEditText.text.toString()
            if (url.isNotBlank() && (url.startsWith("http://") || url.startsWith("https://"))) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.url), Toast.LENGTH_SHORT).show()
            }
            linkEditText.text.clear()
        }

        // Location button click listener
        locationButton.setOnClickListener {
            val location = locationEditText.text.toString()
            if (location.isNotBlank()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$location"))
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.locations), Toast.LENGTH_SHORT).show()
            }
            locationEditText.text.clear()
        }
    }
}
