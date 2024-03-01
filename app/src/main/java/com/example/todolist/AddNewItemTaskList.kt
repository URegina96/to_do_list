package com.example.todolist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class AddNewItemTaskList : AppCompatActivity() {
    private lateinit var adapter: ItemAdapter
    private lateinit var dataList: MutableList<String>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_new_item_task_list_activity)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        dataList = mutableListOf()

        val imageViewSave = findViewById<ImageView>(R.id.imageViewSave)
        imageViewSave.setOnClickListener {
            val nameText = editTextName.text.toString()
            intent.putExtra("nameText", nameText)
            Toast.makeText(this, "Успешно сохранено!", Toast.LENGTH_SHORT).show()
                val dbHelper=DBHelper(this)
                dbHelper.insertItem(nameText)
                dataList.add(nameText)
                adapter = ItemAdapter(dataList, dbHelper)
                adapter.notifyDataSetChanged()
        }
        val  imageViewReturnToList=findViewById<ImageView>(R.id.imageViewReturnToList)
        imageViewReturnToList.setOnClickListener{
            val intent=Intent(this,TaskList::class.java)
            startActivity(intent)
        }
    }
}