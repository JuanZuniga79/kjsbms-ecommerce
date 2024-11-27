package com.rustedcor.userservice.Mappers

import com.rustedcor.userservice.DTO.RoleResponseDTO
import com.rustedcor.userservice.DTO.RoleSaveDTO
import com.rustedcor.userservice.Models.Role
import java.util.*

object RoleMapper {

    fun Role.toRoleResponseDTO() = RoleResponseDTO(
        id = id ?: 0,
        name = name,
        description = description ?: "",
    )

    fun RoleSaveDTO.toRole() = Role(
        name = name,
        description = description,
    )

    fun RoleResponseDTO.toRole() = Role(
        id = id ?: 0,
        name = name,
        description = description,
    )

}