package com.gb.stopwatch.stopwatch

import com.gb.stopwatch.data.TimestampProvider

class ElapsedTimeCalculator(private val timestampProvider: TimestampProvider) {

    fun calculate(state: StopwatchState.Running): Long {
        val currentTimestamp = timestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}