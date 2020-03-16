package com.example.adrianadam.lab5

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.R.attr.name
import android.view.LayoutInflater
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class CarAdapter(_context: Activity): BaseAdapter() {
    var context: Activity = _context
    var cars: ArrayList<Car> = arrayListOf<Car>()

    fun addCar(nameCar: String, resource: Int) {
        val car = Car()
        car.name = nameCar
        car.imageResource = resource
        cars.add(car)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val element: View

        val layoutInflater = context.layoutInflater
        element = layoutInflater.inflate(R.layout.list_item, null)
        val car = TagCar()
        car.name = element.findViewById(R.id.tv_name_element)
        car.image = element.findViewById(R.id.iv_image_element)
        element.tag = car

        val tag = element.tag as TagCar
        tag.name.text = cars.get(position.toInt()).name
        tag.image.setImageResource(cars.get(position).imageResource.toInt())
        return element
    }

    override fun getItem(position: Int): Any {
        return cars.get(position)
    }

    override fun getItemId(position: Int): Long {
        return cars.get(position).imageResource.toLong()
    }

    override fun getCount(): Int {
        return cars.size
    }
}