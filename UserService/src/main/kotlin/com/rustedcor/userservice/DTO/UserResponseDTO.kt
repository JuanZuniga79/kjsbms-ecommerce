package com.rustedcor.userservice.DTO

import com.rustedcor.userservice.Models.Role
import java.time.LocalDateTime
import java.util.UUID

data class UserResponseDTO(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val roleId: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
