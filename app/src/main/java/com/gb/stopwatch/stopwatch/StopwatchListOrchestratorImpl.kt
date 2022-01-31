package com.gb.stopwatch.stopwatch

import com.gb.stopwatch.stopwatch.TimestampMillisecondsFormatter.Companion.DEFAULT_TIME
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class StopwatchListOrchestratorImpl(
    private val stopwatchStateHolder: StopwatchStateHolder
) : StopwatchListOrchestrator {

    private val _ticker = MutableStateFlow(DEFAULT_TIME)
    override val ticker: StateFlow<String> = _ticker.asStateFlow()

    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private var job: Job? = null

    override fun start() {
        if (job == null) startJob()
        stopwatchStateHolder.start()
    }

    private fun startJob() {
        scope.launch {
            while (isActive) {
                _ticker.value = stopwatchStateHolder.getStringTimeRepresentation()
                delay(40)
            }
        }
    }

    override fun pause() {
        stopwatchStateHolder.pause()
        stopJob()
    }

    override fun stop() {
        stopwatchStateHolder.stop()
        stopJob()
        clearValue()
    }

    override fun destroy() {
        stopJob()
        scope.cancel()
    }

    private fun stopJob() {
        scope.coroutineContext.cancelChildren()
        job = null
    }

    private fun clearValue() {
        _ticker.value = DEFAULT_TIME
    }


}