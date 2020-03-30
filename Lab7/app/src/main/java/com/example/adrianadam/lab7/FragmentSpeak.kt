package com.example.adrianadam.lab7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class FragmentSpeak : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        //Inflate the layout for this fragment

        return inflater.inflate(
            R.layout.fragment_one, container, false
        )
    }
}