package com.rustedcor.userservice.DTO

data class UserEditDTO(
    val firstName: String,
    val lastName: String,
    val email: String,
    val roleId: Int
)
