package com.gb.stopwatch.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.stopwatch.databinding.StopwatchItemBinding
import com.gb.stopwatch.view.MainActivity
import com.gb.stopwatch.viewmodel.Stopwatch


class MainAdapter(
    private var data: List<Stopwatch>,
    private val mainActivity: MainActivity
) :
    RecyclerView.Adapter<RecyclerItemViewHolder>() {

    fun setData(data: List<Stopwatch>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        val binding = StopwatchItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RecyclerItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position], mainActivity)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}