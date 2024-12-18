package com.rustedcor.userservice.Repositories

import com.rustedcor.userservice.Models.Role
import org.springframework.data.repository.CrudRepository

interface RoleRepository: CrudRepository<Role, Int> {
    fun findRoleById(roleId: Int): Role;
    fun findAllRoles(): List<Role>;
}