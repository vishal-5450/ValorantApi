package com.daggerhilt.valorantapi.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.daggerhilt.valorantapi.databinding.ActivityMainBinding
import com.daggerhilt.valorantapi.presentation.adapter.AgentAdapter
import com.daggerhilt.valorantapi.presentation.viewmodel.AgentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: AgentViewModel by viewModels()
    private lateinit var adapter: AgentAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AgentAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.agents.observe(this) { agents ->
            Log.d("viewModelErrorValoMainActivity", agents.toString())
            adapter.setAgents(agents)
        }
    }
}