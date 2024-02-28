package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TaskList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_list_activity)
    }
}