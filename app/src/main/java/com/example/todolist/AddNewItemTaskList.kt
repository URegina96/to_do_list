package com.example.todolist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddNewItemTaskList : AppCompatActivity() {
    private lateinit var adapter: ItemAdapter
    private lateinit var dataList: MutableList<String>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_item_task_list)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val textViewItemTaskList = findViewById<TextView>(R.id.textViewItemTaskList)
        val recyclerView =findViewById<RecyclerView>(R.id.RecyclerViewTaskList)

        val imageViewSave = findViewById<ImageView>(R.id.imageViewSave)
        imageViewSave.setOnClickListener {
            val nameText = editTextName.text.toString()
            val dbHelper=DBHelper(this)
            dbHelper.insertItem(nameText)
            dataList.add(nameText)
            adapter.notifyDataSetChanged()
            textViewItemTaskList.text = nameText
        }
        val  imageViewReturnToList=findViewById<ImageView>(R.id.imageViewReturnToList)
        imageViewReturnToList.setOnClickListener{
            val intent=Intent(this,TaskList::class.java)
            startActivity(intent)
        }
    }
}