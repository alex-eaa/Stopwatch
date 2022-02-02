package com.gb.stopwatch.viewmodel

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

internal class MainViewModel : ViewModel(), KoinComponent {

    private val _listStopwatch: MutableList<Stopwatch> = arrayListOf(Stopwatch())
    val listStopwatch: List<Stopwatch> get() = _listStopwatch

    fun insertStopwatch(): Int {
        _listStopwatch.add(Stopwatch())
        return _listStopwatch.size - 1
    }

    fun removeStopwatchByIndex(index: Int) {
        if (index < _listStopwatch.size && _listStopwatch.size > 1) {
            _listStopwatch[index].destroy()
            _listStopwatch.removeAt(index)
        }
    }

    override fun onCleared() {
        _listStopwatch.forEach { it.destroy() }
        super.onCleared()
    }
}