package com.daggerhilt.valorantapi.data.model

import com.daggerhilt.valorantapi.domain.model.Ability

data class AbilityDto(
    val slot: String,
    val displayName: String,
    val description: String,
    val displayIcon: String?
) {
    fun toAbility() = Ability(
        slot = slot,
        displayName = displayName,
        description = description,
        displayIcon = displayIcon
    )
}

