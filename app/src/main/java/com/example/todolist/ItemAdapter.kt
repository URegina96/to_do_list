package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val dataList: MutableList<String>, private val dbHelper: DBHelper) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewItemTaskList: TextView = itemView.findViewById(R.id.textViewItemTaskList)
        var imageViewDelete: ImageView = itemView.findViewById(R.id.imageViewDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task_list_activity, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewItemTaskList.text = dataList[position]
        val item = dataList[position]
        holder.textViewItemTaskList.text = item
        holder.imageViewDelete.setOnClickListener {
            dbHelper.deleteItem(item)
            dataList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataList.size)
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
}