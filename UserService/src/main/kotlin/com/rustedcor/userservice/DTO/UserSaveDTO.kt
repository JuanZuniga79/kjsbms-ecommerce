package com.rustedcor.userservice.DTO

import com.rustedcor.userservice.Models.Role

data class UserSaveDTO(
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: Int,
)
