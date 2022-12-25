package com.example.taskmanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity                 //для базы данных room
data class Task(
    @PrimaryKey(autoGenerate = true)         //для базы данных room
    var id: Int? = null,                      //для базы данных room
    var title: String? = null,
    var desc: String? = null,
): Serializable
