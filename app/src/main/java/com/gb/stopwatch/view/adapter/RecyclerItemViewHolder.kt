package com.gb.stopwatch.view.adapter

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.gb.stopwatch.databinding.StopwatchItemBinding
import com.gb.stopwatch.viewmodel.Stopwatch

class RecyclerItemViewHolder(
    private val viewBinding: StopwatchItemBinding,
    private val lifecycleOwner: LifecycleOwner,
    private val itemOnClickListener: MainAdapter.ItemOnClickListener
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(stopwatch: Stopwatch) {
        viewBinding.buttonStart.setOnClickListener { stopwatch.start() }
        viewBinding.buttonPause.setOnClickListener { stopwatch.pause() }
        viewBinding.buttonStop.setOnClickListener { stopwatch.stop() }

        viewBinding.buttonRemove.setOnClickListener {
            stopwatch.textLiveData.removeObservers(lifecycleOwner)
            itemOnClickListener.clickButtonRemove(adapterPosition)
        }

        stopwatch.textLiveData.observe(lifecycleOwner) {
            viewBinding.textTime.text = it
        }
    }
}