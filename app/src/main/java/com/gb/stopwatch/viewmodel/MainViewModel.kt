package com.gb.stopwatch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gb.stopwatch.stopwatch.StopwatchListOrchestrator
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val stopwatchListOrchestrator: StopwatchListOrchestrator
) : ViewModel() {

    private val _textLiveData: MutableLiveData<String> = MutableLiveData()
    val textLiveData: LiveData<String> get() = _textLiveData

    init {
        viewModelScope.launch {
            stopwatchListOrchestrator.ticker.collect {
                _textLiveData.value = it
            }
        }
    }

    fun start() = stopwatchListOrchestrator.start()
    fun pause() = stopwatchListOrchestrator.pause()
    fun stop() = stopwatchListOrchestrator.stop()

    override fun onCleared() {
        stop()
        super.onCleared()
    }
}