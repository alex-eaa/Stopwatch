package com.gb.stopwatch.viewmodel

import androidx.lifecycle.*
import com.gb.stopwatch.stopwatch.StopwatchListOrchestrator
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val stopwatchListOrchestrator: StopwatchListOrchestrator
) : ViewModel() {

    val textLiveData: LiveData<String> get() = stopwatchListOrchestrator.ticker.asLiveData()

    fun start() = stopwatchListOrchestrator.start()
    fun pause() = stopwatchListOrchestrator.pause()
    fun stop() = stopwatchListOrchestrator.stop()

    override fun onCleared() {
        stop()
        super.onCleared()
    }
}