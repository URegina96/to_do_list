package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ItemTaskList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_task_list_activity)

        val textViewItemTaskList = findViewById<TextView>(R.id.textViewItemTaskList)
        val nameText = intent.getStringExtra("nameText")
        textViewItemTaskList.text = nameText
    }
}