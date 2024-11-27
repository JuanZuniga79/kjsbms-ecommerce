package com.rustedcor.userservice.Repositories

import com.rustedcor.userservice.Models.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository: CrudRepository<User, UUID> {}