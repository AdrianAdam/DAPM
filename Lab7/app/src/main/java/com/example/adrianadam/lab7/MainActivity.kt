package com.example.adrianadam.lab7

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private val REQUEST_CODE_SPEECH_INPUT = 100

    var tvTextFragment1: TextView? = null
    var tvTextFragment2: TextView? = null
    var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnListen = findViewById<Button>(R.id.btnListen)
        var btnSpeak = findViewById<Button>(R.id.btnSpeak)
        tvTextFragment1 = findViewById(R.id.tvFragmentOne)
        tvTextFragment2 = findViewById(R.id.tvFragmentTwo)

        var fr: Fragment

        textToSpeech = TextToSpeech(this, this)

        btnListen.setOnClickListener({
            fr = FragmentListen()
            changeFragment(fr)
            listen()
        })

        btnSpeak.setOnClickListener({
            fr = FragmentSpeak()
            changeFragment(fr)
            speak()
        })
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS)
        {
            textToSpeech!!.setLanguage(Locale.US)
        }
        else
        {
            Log.e("TTS", "Initilization Failed!")
        }
    }

    fun changeFragment(fr: Fragment)
    {
        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_place, fr)
        fragmentTransaction.commit()
    }

    fun speak()
    {
        val mIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-En")
        mIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak")

        try
        {
            startActivityForResult(mIntent, REQUEST_CODE_SPEECH_INPUT)
        }
        catch(e: Exception)
        {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun listen()
    {
        val text = tvTextFragment1!!.text.toString()
Log.e("TEST", text)
        textToSpeech!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode)
        {
            REQUEST_CODE_SPEECH_INPUT -> {
                if(resultCode == Activity.RESULT_OK && null != data)
                {
                    val arrResult = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)

                    tvTextFragment1?.text = arrResult[0]
                    tvTextFragment2?.text = arrResult[0]
                }
            }
        }
    }

    public override fun onDestroy() {
        if(textToSpeech != null)
        {
            textToSpeech!!.stop()
            textToSpeech!!.shutdown()
        }
        super.onDestroy()
    }
}
