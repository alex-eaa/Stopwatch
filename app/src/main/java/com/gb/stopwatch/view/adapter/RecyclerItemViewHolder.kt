package com.gb.stopwatch.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.gb.stopwatch.databinding.StopwatchItemBinding
import com.gb.stopwatch.view.MainActivity
import com.gb.stopwatch.viewmodel.Stopwatch

class RecyclerItemViewHolder(private val viewBinding: StopwatchItemBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(stopwatch: Stopwatch, mainActivity: MainActivity) {
        viewBinding.number.text = (adapterPosition + 1).toString()
        viewBinding.buttonStart.setOnClickListener { stopwatch.start() }
        viewBinding.buttonPause.setOnClickListener { stopwatch.pause() }
        viewBinding.buttonStop.setOnClickListener { stopwatch.stop() }

        stopwatch.textLiveData.observe(mainActivity) {
            viewBinding.textTime.text = it
        }
    }
}