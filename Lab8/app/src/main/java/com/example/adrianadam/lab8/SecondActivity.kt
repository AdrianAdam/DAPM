package com.example.adrianadam.lab8

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.TextView
import com.google.firebase.database.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        var listView: ListView = findViewById(R.id.lv_list_posts)

        var postAdapter: PostAdapter = PostAdapter(this)

        var databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("posts/AdrysTargaryen")

        databaseReference.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                postAdapter.addPost(p0.child("username").value.toString(), p0.child("time").value.toString(), p0.child("post").value.toString())
            }

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildRemoved(p0: DataSnapshot) {

            }
        })

        listView.adapter = postAdapter
    }
}

class Post {
    lateinit var name: String
    lateinit var time: String
    lateinit var message: String
}

class TagPost {
    lateinit var name: TextView
    lateinit var time: TextView
    lateinit var message: TextView
}