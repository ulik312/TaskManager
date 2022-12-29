package com.example.taskmanager.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.App
import com.example.taskmanager.R
import com.example.taskmanager.databinding.FragmentTaskBinding
import com.example.taskmanager.model.Task
import com.example.taskmanager.ui.home.HomeFragment


class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private var task: Task? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        task = arguments?.getSerializable(HomeFragment.KEY_FOR_TASK) as Task?

        if(task == null){
            binding.btnSave.text = getString(R.string.save)
        } else {
            binding.etTitle.setText(task?.title.toString())
            binding.etDesc.setText(task?.desc.toString())
            binding.btnSave.text = getString(R.string.update)
        }

        binding.btnSave.setOnClickListener {
            if (task == null) {
                save()
            } else {
                update()
        }
    }
    }

    private fun save() {
        val data = Task(
            title = binding.etTitle.text.toString(),
            desc = binding.etDesc.text.toString())
        App.db.dao().insert(data)
        //App.db.dao().delete(data)
        //setFragmentResult("rq_task", bundleOf("task" to data))
        findNavController().navigateUp()
    }

    private fun update(){
        task?.title = binding.etTitle.text.toString()
        task?.desc = binding.etDesc.text.toString()
        task?.let { App.db.dao().update(it) }
        findNavController().navigateUp()

    }

}