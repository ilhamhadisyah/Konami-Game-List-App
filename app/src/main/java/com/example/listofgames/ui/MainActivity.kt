package com.example.listofgames.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listofgames.R
import com.example.listofgames.data.source.retrofit.ApiHelper
import com.example.listofgames.data.source.retrofit.RetrofitService
import com.example.listofgames.databinding.ActivityMainBinding
import com.example.listofgames.networkutils.Status
import com.example.listofgames.viewmodel.MainViewModel
import com.example.listofgames.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: Adapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            setDisplayShowCustomEnabled(true)
            setCustomView(R.layout.custom_toolbar)
            elevation = 3f
        }
        viewModel =
            ViewModelProviders.of(this, ViewModelFactory(ApiHelper(RetrofitService.apiService)))
                .get(MainViewModel::class.java)

        binding.rvGames.layoutManager = LinearLayoutManager(this)

        viewModel.getGamesData().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.progress.visibility = View.GONE
                        resource.data?.let { data ->
                            adapter = Adapter(data)
                            binding.rvGames.adapter = adapter
                        }
                    }
                    Status.ERROR -> {}
                    Status.LOADING -> {binding.progress.visibility = View.VISIBLE}
                }
            }


        })
    }
}