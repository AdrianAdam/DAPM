package com.example.adrianadam.lab6

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etText = findViewById<EditText>(R.id.etMainText)
        var btnSave = findViewById<Button>(R.id.btnSave)
        var btnSecondActivity = findViewById<Button>(R.id.btnSecondActivity)

        var sharedPreference: MySharedPreference = MySharedPreference(this)

        btnSave.setOnClickListener({
            sharedPreference.save(etText.text.toString())
        })

        btnSecondActivity.setOnClickListener({
            val objIntent = Intent(this, SecondActivity::class.java)
            objIntent.putExtra("extra", "Test extra")
            startActivity(objIntent)
        })
    }
}
