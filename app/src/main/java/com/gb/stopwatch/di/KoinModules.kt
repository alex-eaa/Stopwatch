package com.gb.stopwatch.di


import com.gb.stopwatch.data.TimestampProvider
import com.gb.stopwatch.data.TimestampProviderImpl
import com.gb.stopwatch.stopwatch.*
import com.gb.stopwatch.stopwatch.ElapsedTimeCalculator
import com.gb.stopwatch.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single<TimestampProvider> { TimestampProviderImpl() }

    single { TimestampMillisecondsFormatter() }
    single { ElapsedTimeCalculator(get()) }
    factory { StopwatchStateCalculator(get(), get()) }
    factory { StopwatchStateHolder(get(), get(), get()) }
    factory<StopwatchListOrchestrator> { StopwatchListOrchestratorImpl(get()) }

    viewModel { MainViewModel() }
}