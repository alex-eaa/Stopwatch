package com.gb.stopwatch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.gb.stopwatch.stopwatch.StopwatchListOrchestrator
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class Stopwatch : KoinComponent {
    private val stopwatchListOrchestrator: StopwatchListOrchestrator = get()
    val textLiveData: LiveData<String> = stopwatchListOrchestrator.ticker.asLiveData()

    fun start() = stopwatchListOrchestrator.start()
    fun pause() = stopwatchListOrchestrator.pause()
    fun stop() = stopwatchListOrchestrator.stop()
    fun destroy() = stopwatchListOrchestrator.destroy()
}