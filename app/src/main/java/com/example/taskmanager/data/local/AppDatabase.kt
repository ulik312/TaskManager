package com.example.taskmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskmanager.ui.model.Task

@Database(entities = [Task::class], version = 1)

abstract class AppDatabase: RoomDatabase() {
    abstract fun dao(): TaskDao
}