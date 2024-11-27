package com.rustedcor.userservice.DTO

data class RoleResponseDTO(
    val id: Int,
    val name: String,
    val description: String? = null,
)
