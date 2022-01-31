package com.gb.stopwatch.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.gb.stopwatch.R
import com.gb.stopwatch.databinding.ActivityMainBinding
import com.gb.stopwatch.view.adapter.MainAdapter
import com.gb.stopwatch.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    private var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (adapter == null) {
            adapter = MainAdapter(viewModel.listStopwatch, this)
            binding.recyclerview.adapter = adapter
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                viewModel.addStopwatch()
                adapter?.setData(viewModel.listStopwatch)
                true
            }
            R.id.action_delete -> {
                viewModel.deleteStopwatch()
                adapter?.setData(viewModel.listStopwatch)
                true
            }
            else -> true
        }
    }
}


