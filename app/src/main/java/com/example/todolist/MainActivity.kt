package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val addButtonGoToList = findViewById<ImageView>(R.id.imageViewGoToList)
        addButtonGoToList.setOnClickListener {
            val intent = Intent(this, TaskList::class.java)
            startActivity(intent)
        }

        val addButtonAddingNewTasks = findViewById<ImageView>(R.id.imageViewAddingNewTasks)
        addButtonAddingNewTasks.setOnClickListener {
            val intent = Intent(this, AddNewItemTaskList::class.java)
            startActivity(intent)
        }
    }
}