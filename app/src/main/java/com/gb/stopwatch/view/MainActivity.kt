package com.gb.stopwatch.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.gb.stopwatch.databinding.ActivityMainBinding
import com.gb.stopwatch.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.textLiveData.observe(this) {
            binding.textTime.text = it
        }

        initView()
    }

    private fun initView() {
        binding.buttonStart.setOnClickListener { viewModel.start() }
        binding.buttonPause.setOnClickListener { viewModel.pause() }
        binding.buttonStop.setOnClickListener { viewModel.stop() }
    }
}


