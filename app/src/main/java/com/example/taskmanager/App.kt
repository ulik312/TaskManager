package com.example.taskmanager

import android.app.Application
import androidx.room.Room
import com.example.taskmanager.data.local.AppDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class App: Application() {                              // здесь дали название нашему приложению

    override fun onCreate() {                             // создали первый метод который запускается в нашем приложений
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database_name"           //создали экземпляр класса дата басе database
        ).allowMainThreadQueries().build()                           //allowMainThreadQueries помогает создать в главном потоке базу данных если выходит ошибка
        firebaseDB = FirebaseFirestore.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("tasks")
    }

    companion object{
        lateinit var db: AppDatabase                            //создаем базу данных а точнее database
        var firebaseDB: FirebaseFirestore? = null
        var databaseReference: DatabaseReference? = null
    }
}