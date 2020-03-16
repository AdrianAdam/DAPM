package com.example.adrianadam.lab5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView: ListView = findViewById(R.id.lv_list_cars)

        var carAdapter: CarAdapter = CarAdapter(this)

        carAdapter.addCar("Car1", R.drawable.lab5_car_icon)
        carAdapter.addCar("Car2", R.drawable.lab5_car_icon)
        carAdapter.addCar("Car3", R.drawable.lab5_car_icon)
        carAdapter.addCar("Car4", R.drawable.lab5_car_icon)

        var button: Button = findViewById(R.id.b_add_car)
        var editText: EditText = findViewById(R.id.ed_new_car)

        button.setOnClickListener({
            carAdapter.addCar(editText.text.toString(), R.drawable.lab5_car_icon)
            editText.text.clear()
        })

        listView.adapter = carAdapter
    }
}

class Car {
    lateinit var name: String
    lateinit var imageResource: Number
}

class TagCar {
    lateinit var name: TextView
    lateinit var image: ImageView
}
