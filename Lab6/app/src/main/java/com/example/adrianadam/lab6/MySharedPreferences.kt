package com.example.adrianadam.lab6

import android.content.Context
import android.content.SharedPreferences


class MySharedPreference(context: Context)
{
    internal var settings: SharedPreferences = context.getSharedPreferences("com.adrianadam.prefs", 0)
    internal var editor: SharedPreferences.Editor = context.getSharedPreferences("com.adrianadam.prefs", 0).edit()

    fun getValue(): String {
        return settings.getString("test", "")
    }


    fun save(text: String) {
        editor.putString("test", text)

        editor.commit()
    }

    fun clearSharedPreferences() {
        editor.clear()

        editor.commit()
    }
}