package com.gb.stopwatch.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.gb.stopwatch.databinding.StopwatchItemBinding
import com.gb.stopwatch.viewmodel.Stopwatch


class MainAdapter(
    private val data: List<Stopwatch>,
    private val lifecycleOwner: LifecycleOwner,
    private val itemOnClickListener: ItemOnClickListener,
) :
    RecyclerView.Adapter<RecyclerItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        val binding = StopwatchItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RecyclerItemViewHolder(binding, lifecycleOwner, itemOnClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface ItemOnClickListener{
        fun clickButtonRemove(position: Int)
    }
}