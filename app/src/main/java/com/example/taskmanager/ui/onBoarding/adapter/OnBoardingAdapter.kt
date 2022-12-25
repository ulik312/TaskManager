package com.example.taskmanager.ui.onBoarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager.R
import com.example.taskmanager.databinding.ItemBoardingBinding
import com.example.taskmanager.model.OnBoard

class OnBoardingAdapter(private val context: Context, private val onClick: ()-> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoard(R.drawable.ic_juice_1, "juice_Fresh1"),
        OnBoard(R.drawable.ic_juice_2, "juice_Fresh2"),
        OnBoard(R.drawable.ic_juice_1, "juice_Fresh3")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemBoardingBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.ivBoarding.setImageResource(onBoard.image!!)

            if (adapterPosition == data.lastIndex) {
                binding.tvSkip.text = context.getString(R.string.next)
            } else binding.tvSkip.text = context.getString(R.string.skip)
            binding.tvSkip.setOnClickListener {
                onClick()
            }
        }


    }
}