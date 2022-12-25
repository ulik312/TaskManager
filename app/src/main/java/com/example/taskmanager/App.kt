package com.example.taskmanager

import android.app.Application
import androidx.room.Room
import com.example.taskmanager.data.local.AppDatabase

class App: Application() {                              // здесь дали название нашему приложению

    override fun onCreate() {                             // создали первый метод который запускается в нашем приложений
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database_name"           //создали экземпляр класса дата басе database
        ).allowMainThreadQueries().build()                           //allowMainThreadQueries помогает создать в главном потоке базу данных если выходит ошибка
    }

    companion object{
        lateinit var db: AppDatabase                              //создаем базу данных а точнее database
    }
}