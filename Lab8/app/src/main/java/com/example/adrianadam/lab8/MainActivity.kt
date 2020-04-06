package com.example.adrianadam.lab8

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etEmailAddress = findViewById<EditText>(R.id.etEmailAddress)
        var etPassword = findViewById<EditText>(R.id.etPassword)
        var btnLogin = findViewById<Button>(R.id.btnLogin)

        var mAuth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener({
            mAuth.signInWithEmailAndPassword(etEmailAddress.text.toString(), etPassword.text.toString())
                .addOnCompleteListener(this) { task ->
                    if(task.isSuccessful)
                    {
                        var objIntent = Intent(this, SecondActivity::class.java)
                        startActivity(objIntent)
                    }
                    else
                    {
                        Log.e("Login failed", task.exception.toString())
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        })
    }
}
