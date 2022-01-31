package com.gb.stopwatch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gb.stopwatch.data.TimestampProvider
import com.gb.stopwatch.data.TimestampProviderImpl
import com.gb.stopwatch.stopwatch.*
import com.gb.stopwatch.view.ElapsedTimeCalculator
import kotlinx.coroutines.launch


internal class MainViewModel(
    private var timestampProvider: TimestampProvider = TimestampProviderImpl()
) : ViewModel() {

    private val _textLiveData: MutableLiveData<String> = MutableLiveData()
    val textLiveData: LiveData<String> get() = _textLiveData

    private val stopwatchListOrchestrator : StopwatchListOrchestrator = StopwatchListOrchestratorImpl(
        StopwatchStateHolder(
            StopwatchStateCalculator(timestampProvider, ElapsedTimeCalculator(timestampProvider)),
            ElapsedTimeCalculator(timestampProvider),
            TimestampMillisecondsFormatter()
        ),
        viewModelScope
    )

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
}