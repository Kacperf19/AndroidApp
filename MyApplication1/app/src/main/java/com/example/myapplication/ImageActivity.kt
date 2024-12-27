package com.example.myapplication

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class ImageActivity : AppCompatActivity() {
    private val imageList = listOf(
        R.drawable.ob1,
        R.drawable.ob2,
        R.drawable.ob3,
        R.drawable.ob4,
        R.drawable.ob5,

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image) // Replace with actual layout name

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageF = findViewById<ImageView>(R.id.ImageFish)
        val randomImageBTN = findViewById<Button>(R.id.randomImageBTN)
        val monoBTN = findViewById<Button>(R.id.MonoBTN)
        val barGrey = findViewById<SeekBar>(R.id.BarGrey)
        val barAlfa = findViewById<SeekBar>(R.id.BarAlfa)

        // Set initial image
        imageF.setImageResource(getRandomIMG())
        imageF.layoutParams.width = 200
        imageF.layoutParams.height = 200

        randomImageBTN.setOnClickListener {
            imageF.setImageResource(getRandomIMG())
        }

        var isMonochrome = false
        monoBTN.setOnClickListener {
            isMonochrome = !isMonochrome
            if (isMonochrome) {
                val colorMatrix = ColorMatrix()
                colorMatrix.setSaturation(0f)
                imageF.colorFilter = ColorMatrixColorFilter(colorMatrix)
                monoBTN.text = getString(R.string.switchchangecolor).toString()
            } else {
                monoBTN.text = getString(R.string.switchImnage).toString()
                imageF.colorFilter = null
            }
        }

        barGrey.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val newSize = progress.coerceIn(1, 666)
                imageF.layoutParams.width = newSize
                imageF.layoutParams.height = newSize
                imageF.requestLayout()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        barAlfa.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                imageF.imageAlpha = progress.coerceIn(0, 255)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun getRandomIMG(): Int {
        val index = (imageList.indices).random()
        return imageList[index]
    }
}
