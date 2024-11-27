package com.rustedcor.userservice.Controllers

import com.rustedcor.userservice.DTO.RoleResponseDTO
import com.rustedcor.userservice.DTO.RoleSaveDTO
import com.rustedcor.userservice.Mappers.RoleMapper.toRoleResponseDTO
import com.rustedcor.userservice.Services.RoleServices
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/roles")
class RoleController(private val roleService: RoleServices) {

    @GetMapping("/{id}")
    fun getRoleById(@PathVariable id: Int): ResponseEntity<RoleResponseDTO> {
        val roleResponse = roleService.getRoleById(id)
        return ResponseEntity.ok(roleResponse)
    }

    @GetMapping
    fun getAllRoles(): ResponseEntity<List<RoleResponseDTO>> {
        val roles = roleService.getAllRoles()
        return if(roles.isEmpty()) ResponseEntity.noContent().build() else ResponseEntity.ok(roles)
    }

    @PostMapping
    fun createRole(@RequestBody roleSaveDTO: RoleSaveDTO): ResponseEntity<RoleResponseDTO> {
        val createdRole = roleService.createRole(roleSaveDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole)
    }

    @DeleteMapping("/{id}")
    fun deleteRole(@PathVariable id: Int): ResponseEntity<Void> {
        return if (roleService.deleteRoleById(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
