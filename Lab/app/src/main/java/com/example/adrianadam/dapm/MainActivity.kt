package com.example.adrianadam.dapm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var elButton1 = findViewById<Button>(R.id.elButton1)
        var elButton2 = findViewById<Button>(R.id.elButton2)

        elButton2.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Pushed button 2", Toast.LENGTH_LONG).show()
        })

        Log.e("onCreate", "Log on create")
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "Log on start")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart", "Log on restart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume", "Log on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause", "Log on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop", "Log on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "Log on destroy")
    }

    fun alertUser(view: View)
    {
        Toast.makeText(this, "Pushed button 1", Toast.LENGTH_LONG).show()
        Log.v("Ex2", "test in verbose")
        Log.d("Ex2", "test in debug")
        Log.i("Ex2", "test in info")
        Log.e("Ex2", "test in error")
        Log.w("Ex2", "test in warning")
    }
}