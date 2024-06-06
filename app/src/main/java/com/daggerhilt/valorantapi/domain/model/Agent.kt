package com.daggerhilt.valorantapi.domain.model

data class Agent(
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val role: Role,
    val abilities: List<Ability>
)
