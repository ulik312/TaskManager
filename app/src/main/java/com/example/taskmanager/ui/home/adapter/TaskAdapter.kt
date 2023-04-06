package com.example.taskmanager.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.ui.model.Task
import com.example.taskmanager.databinding.ItemTaskBinding

class TaskAdapter(var listener: Listener): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val data : ArrayList<Task> = arrayListOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent,
            false))
    }
    /*fun addTask(task: Task){
        data.add(0,task)
        notifyDataSetChanged()
    }*/
    fun addTasks (newData: List<Task>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    fun onTaskDelete(task: Task){
        data.remove(task)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position], listener, position)

    }

    override fun getItemCount(): Int {
        return data.size
    }
    inner class TaskViewHolder(private val binding : ItemTaskBinding )
        : RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task, listener: Listener, position: Int) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc
            itemView.setOnLongClickListener {
                listener.onTaskDeleteClickListener(task, position)
                true
            }
            itemView.setOnClickListener {
                listener.onClick(task)

            }

        }

    }


    interface Listener{
        fun onTaskDeleteClickListener(task : Task, position: Int)
        fun onClick(task: Task)
    }

}