package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)

        // Delay of 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Start LoginActivity after 3 seconds
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()  // Finish SplashActivity so it cannot be returned to
        }, 3000) // 3000 ms = 3 seconds
    }
}
