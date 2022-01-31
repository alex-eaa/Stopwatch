package com.gb.stopwatch.stopwatch

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface StopwatchListOrchestrator {
    val ticker: StateFlow<String>

    fun start()
    fun pause()
    fun stop()
}