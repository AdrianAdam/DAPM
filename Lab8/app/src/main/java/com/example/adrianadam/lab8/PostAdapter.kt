package com.example.adrianadam.lab8

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.R.attr.name
import android.view.LayoutInflater
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class PostAdapter(_context: Activity): BaseAdapter() {
    var context: Activity = _context
    var posts: ArrayList<Post> = arrayListOf<Post>()

    fun addPost(name: String, time: String, message: String) {
        val post = Post()
        post.name = name
        post.time = time
        post.message = message
        posts.add(post)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val element: View

        val layoutInflater = context.layoutInflater
        element = layoutInflater.inflate(R.layout.list_item, null)
        val post = TagPost()
        post.name = element.findViewById(R.id.tv_name_element)
        post.time = element.findViewById(R.id.tv_time_element)
        post.message = element.findViewById(R.id.tv_message_element)
        element.tag = post

        val tag = element.tag as TagPost
        tag.name.text = posts.get(position).name
        tag.time.text = posts.get(position).time
        tag.message.text = posts.get(position).message
        return element
    }

    override fun getItem(position: Int): Any {
        return posts.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return posts.size
    }
}