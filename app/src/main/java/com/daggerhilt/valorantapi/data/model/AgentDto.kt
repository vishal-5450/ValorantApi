package com.daggerhilt.valorantapi.data.model

import com.daggerhilt.valorantapi.domain.model.Agent
import com.daggerhilt.valorantapi.domain.model.Role

data class AgentDto(
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val role: RoleDto?,
    val abilities: List<AbilityDto>
) {
    fun toAgent() = Agent(
        displayName = displayName,
        description = description,
        displayIcon = displayIcon,
        role = role?.toRole() ?: Role("Unknown", "No description", ""),
        abilities = abilities.map { it.toAbility() }
    )
}
