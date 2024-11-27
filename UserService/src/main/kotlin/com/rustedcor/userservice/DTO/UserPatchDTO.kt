package com.rustedcor.userservice.DTO

data class UserPatchDTO(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val roleId: Int?
)