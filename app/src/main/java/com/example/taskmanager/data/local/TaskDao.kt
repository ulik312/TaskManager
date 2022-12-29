package com.example.taskmanager.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.taskmanager.model.Task

@Dao                      // он нужен для библеотки базы данных room, для того чтобы сохранять,получать,удалять, итд
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY id DESC")   //он нужен для того чтобы получать данные
    fun getAll(): List<Task>

    @Insert                       // он нужен чтобы добавлять данные в базу данных
    fun insert(task: Task)

    @Delete                         //он нужен чтобы удалять данные из базы данных
    fun delete(task: Task)

    @Update
    fun update(task: Task)             //Он нужен для того чтобы обновить данные из базы
}
