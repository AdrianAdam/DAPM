package com.example.adrianadam.lab4

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText

class Login: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var strUsername = findViewById<EditText>(R.id.strUsername)
        var strPassword = findViewById<EditText>(R.id.strPassword)

        var btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener{
            if(strPassword.text.toString().equals("student") && strUsername.text.toString().equals("student"))
            {
                Log.e("Test", "aici")
                val objIntent = Intent(this, MainActivity::class.java)
                startActivity(objIntent)
            }
        }
    }
}