package com.example.todolist

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "users"
        const val TABLE_CONTACTS = "contacts"
        const val KEY_NAME = "name"
    }
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        // код для создания таблицы при первом запуске базы данных
        val tableName = TABLE_CONTACTS
        val CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS $tableName ($KEY_NAME TEXT, column2 INTEGER)"
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // код для обновления таблицы при изменении версии базы данных
        val tableName = TABLE_CONTACTS
        val DROP_TABLE_QUERY = "DROP TABLE IF EXISTS $tableName"
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY)
        onCreate(sqLiteDatabase)
    }
    fun insertItem(itemName: String) {
          // для сохранения textView->name в базу данных
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, itemName)
        db.insert(TABLE_CONTACTS, null, values)
        db.close()
    }
    fun getAllItems(): List<String> {
        //  метод для получения всех элементов из базы данных
        val itemList = mutableListOf<String>()
        val selectQuery = "SELECT * FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex(KEY_NAME)
            do {
                val itemName = cursor.getString(columnIndex)
                itemList.add(itemName)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return itemList
    }

    fun deleteItem(nameText: String?) {
        val db = this.writableDatabase
        db.delete(TABLE_CONTACTS, "$KEY_NAME = ?", arrayOf(nameText))
        db.close()
    }
}