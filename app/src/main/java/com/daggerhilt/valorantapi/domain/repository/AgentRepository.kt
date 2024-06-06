package com.daggerhilt.valorantapi.domain.repository

import com.daggerhilt.valorantapi.domain.model.Agent

interface AgentRepository {
    suspend fun getAgents(): List<Agent>
}
