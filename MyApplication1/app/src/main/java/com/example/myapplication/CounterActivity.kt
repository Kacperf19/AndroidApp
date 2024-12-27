package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterActivity : AppCompatActivity() {

var counter = 0       // Przechowywanie aktualnej wartości licznika
    private var step = 1          // Wartość kroku, początkowo ustawiona na +1 lub -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        // Inicjalizacja widoków
        val counterTextView = findViewById<TextView>(R.id.counterTextView)
        val increaseButton = findViewById<Button>(R.id.increaseButton)
        val decreaseButton = findViewById<Button>(R.id.decreaseButton)
        val incrementSwitch = findViewById<Switch>(R.id.incrementSwitch)
        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val setButton = findViewById<Button>(R.id.setButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Ustawienie początkowej wartości licznika
        counterTextView.text = counter.toString()

        // Obsługa przełącznika, aby zmienić krok na 1 lub 2
        incrementSwitch.setOnCheckedChangeListener { _, isChecked ->
            step = if (isChecked) 2 else 1
            increaseButton.text = if (isChecked) "+2" else "+1"
            decreaseButton.text = if (isChecked) "-2" else "-1"
        }

        // Obsługa przycisku zwiększającego licznik
        increaseButton.setOnClickListener {
            counter += step
            counterTextView.text = counter.toString()
        }

        // Obsługa przycisku zmniejszającego licznik
        decreaseButton.setOnClickListener {
            counter -= step
            counterTextView.text = counter.toString()
        }
        setButton.setOnClickListener {
            val inputText = inputEditText.text.toString()
            if (inputText.isNotEmpty()) {
                counter = inputText.toInt()
                counterTextView.text = counter.toString()
                inputEditText.text.clear() // Czyszczenie pola po ustawieniu
            }
        }

        // Obsługa przycisku resetującego licznik
        resetButton.setOnClickListener {
            counter = 0
            counterTextView.text = counter.toString()
        }
    }
}