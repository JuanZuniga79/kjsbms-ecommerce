package com.rustedcor.userservice.Mappers

import com.rustedcor.userservice.DTO.UserResponseDTO
import com.rustedcor.userservice.DTO.UserSaveDTO
import com.rustedcor.userservice.Models.Role
import com.rustedcor.userservice.Models.User
import java.time.LocalDateTime
import java.util.UUID

object UserMapper {

    fun User.toUserResponseDTO() = UserResponseDTO(
        id = id ?: UUID.randomUUID(),
        firstName = firstName,
        lastName = lastName,
        email = email,
        role = role,
        createdAt = createdAt?: LocalDateTime.now(),
        updatedAt = updatedAt?: LocalDateTime.now(),
    )

    fun UserSaveDTO.toUser(role: Role) = User(
        firstName = firstName,
        lastName = lastName,
        email = email,
        role = role
    )

}