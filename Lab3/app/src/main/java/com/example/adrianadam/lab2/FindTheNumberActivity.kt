package com.example.adrianadam.lab2

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.roundToInt

class FindTheNumberActivity : AppCompatActivity() {

    lateinit var strGuess: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        strGuess = findViewById(R.id.strGuess)

        var nGeneratedGuess = Math.random() * 10
        var nGeneratedGuessInt = nGeneratedGuess.roundToInt()
        var strGeneratedGuess = nGeneratedGuessInt.toString()
        Log.e("test", strGeneratedGuess)

        var btnGuess = findViewById<Button>(R.id.btnGuess)

        btnGuess.setOnClickListener{
            if(strGuess.text.toString().equals(strGeneratedGuess))
            {
                Toast.makeText(this, "You guessed the right number : " + strGuess.text.toString(), Toast.LENGTH_LONG).show()
            }

            btnGuess.textColors.defaultColor

            if(btnGuess.textColors.defaultColor == Color.RED)
            {
                btnGuess.setTextColor(Color.BLUE)
            }
            else
            {
                btnGuess.setTextColor(Color.RED)
            }
        }
    }
}
