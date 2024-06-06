package com.daggerhilt.valorantapi.data.model

import com.daggerhilt.valorantapi.domain.model.Role

data class RoleDto(
    val displayName: String,
    val description: String,
    val displayIcon: String
) {
    fun toRole() = Role(
        displayName = displayName,
        description = description,
        displayIcon = displayIcon
    )
}
