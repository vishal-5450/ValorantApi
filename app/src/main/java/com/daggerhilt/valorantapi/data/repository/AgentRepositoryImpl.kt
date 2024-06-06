package com.daggerhilt.valorantapi.data.repository

import android.util.Log
import com.daggerhilt.valorantapi.data.model.AgentDto
import com.daggerhilt.valorantapi.data.remote.AgentResponse
import com.daggerhilt.valorantapi.data.remote.ValorantApiService
import com.daggerhilt.valorantapi.domain.model.Agent
import com.daggerhilt.valorantapi.domain.repository.AgentRepository
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(
    private val apiService: ValorantApiService
) : AgentRepository {
    override suspend fun getAgents(): List<Agent> {
        return try {
            val response: AgentResponse = apiService.getAgents()
            if (response.status == 200) {
                val agentDtos: List<AgentDto> = response.data
                agentDtos.forEach { agentDto ->
                    Log.d("AgentRepository", "AgentDto: $agentDto")
                }
                agentDtos.map { it.toAgent() }
            } else {
                Log.e("AgentRepository", "Failed to fetch agents, status: ${response.status}")
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("AgentRepository", "Error fetching agents: ${e.message}", e)
            emptyList()
        }
    }
}
