package com.daggerhilt.valorantapi.data.remote

import com.daggerhilt.valorantapi.data.model.AgentDto
import retrofit2.http.GET

interface ValorantApiService {
    @GET("/v1/agents")
    suspend fun getAgents(): AgentResponse
}

data class AgentResponse(
    val status: Int,
    val data: List<AgentDto>
)
