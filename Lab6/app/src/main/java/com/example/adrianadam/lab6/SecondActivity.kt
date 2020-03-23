package com.example.adrianadam.lab6

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var tvText = findViewById<TextView>(R.id.tvSecondActivity)

        var sharedPreference: MySharedPreference = MySharedPreference(this)

        tvText.text = sharedPreference.getValue()

        var strExtra: String = intent.getStringExtra("extra")

        Toast.makeText(this, strExtra, Toast.LENGTH_LONG).show()
    }
}