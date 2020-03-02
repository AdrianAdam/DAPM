package com.example.adrianadam.lab2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var strUsername = findViewById<EditText>(R.id.strUsername)
        var strPassword = findViewById<EditText>(R.id.strPassword)

        var btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener{
            if(strPassword.text.toString().equals("student") && strUsername.text.toString().equals("student"))
            {
                Log.e("Test", "aici")
                val objIntent = Intent(this, FindTheNumberActivity::class.java)
                startActivity(objIntent)
            }
        }
    }
}
