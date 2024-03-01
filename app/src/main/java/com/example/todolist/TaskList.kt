package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_list_activity)

        val recyclerViewTaskList = findViewById<RecyclerView>(R.id.RecyclerViewTaskList)
        val dbHelper = DBHelper(this)
        val dataList = dbHelper.getAllItems().toMutableList()
        val adapter = ItemAdapter(dataList, dbHelper)
        recyclerViewTaskList.layoutManager = LinearLayoutManager(this)
        recyclerViewTaskList.adapter = adapter
    }
}
