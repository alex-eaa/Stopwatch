package com.gb.stopwatch.data

class TimestampProviderImpl : TimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()
    }
}