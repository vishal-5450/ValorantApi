package com.daggerhilt.valorantapi.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daggerhilt.valorantapi.domain.model.Agent
import com.daggerhilt.valorantapi.domain.repository.AgentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentViewModel @Inject constructor(
    private val repository: AgentRepository
) : ViewModel() {

    private val _agents = MutableLiveData<List<Agent>>()
    val agents: LiveData<List<Agent>> = _agents

    init {
        fetchAgents()
    }

    private fun fetchAgents() {
        viewModelScope.launch {
            try {
                val agentList = repository.getAgents()
                if (agentList.isEmpty()) {
                    Log.d("viewModelErrorValo", "Agent list is empty or null")
                } else {
                    _agents.postValue(agentList)
                }
            } catch (e: Exception) {
                Log.d("viewModelErrorValo", "Error fetching agents: ${e.message}")
            }
        }
    }
}
