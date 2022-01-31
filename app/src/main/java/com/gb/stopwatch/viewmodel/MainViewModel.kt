package com.gb.stopwatch.viewmodel

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

internal class MainViewModel : ViewModel(), KoinComponent {

    val listStopwatch: ArrayList<Stopwatch> = arrayListOf(Stopwatch())

    fun addStopwatch() {
        listStopwatch.add(Stopwatch())
    }

    fun deleteStopwatch() {
        if (listStopwatch.size > 1) {
            val index = listStopwatch.size - 1
            listStopwatch[index].destroy()
            listStopwatch.removeAt(index)
        }
    }

    override fun onCleared() {
        listStopwatch.forEach { it.destroy() }
        super.onCleared()
    }
}