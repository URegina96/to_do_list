package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class TaskList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_list_activity)

        val recyclerViewTaskList = findViewById<RecyclerView>(R.id.RecyclerViewTaskList)
        recyclerViewTaskList.setOnClickListener{

        }
    }
}