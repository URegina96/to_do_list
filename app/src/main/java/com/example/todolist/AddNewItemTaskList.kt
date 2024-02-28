package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AddNewItemTaskList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_item_task_list)

        val imageViewSave = findViewById<ImageView>(R.id.imageViewSave)
        imageViewSave.setOnClickListener {
        }
        val  imageViewReturnToList=findViewById<ImageView>(R.id.imageViewReturnToList)
        imageViewReturnToList.setOnClickListener{
            val intent=Intent(this,TaskList::class.java)
            startActivity(intent)
        }
    }
}