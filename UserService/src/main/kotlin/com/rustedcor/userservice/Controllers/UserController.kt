package com.rustedcor.userservice.Controllers

import com.rustedcor.userservice.DTO.UserEditDTO
import com.rustedcor.userservice.DTO.UserPatchDTO
import com.rustedcor.userservice.DTO.UserResponseDTO
import com.rustedcor.userservice.DTO.UserSaveDTO
import com.rustedcor.userservice.Mappers.UserMapper.toUserResponseDTO
import com.rustedcor.userservice.Services.UserServices
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserServices) {

    @PostMapping
    fun createUser(@RequestBody userSaveDTO: UserSaveDTO): ResponseEntity<UserResponseDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userSaveDTO))
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): ResponseEntity<UserResponseDTO> {
        return ResponseEntity.ok(userService.getUserById(id))
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<MutableList<UserResponseDTO>> {
        val users = userService.getAllUsers()
        return if (users.isEmpty()) ResponseEntity.noContent().build() else ResponseEntity.ok(users)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody userEditDTO: UserEditDTO): ResponseEntity<UserResponseDTO> {
        return ResponseEntity.ok(userService.putUser(userEditDTO, id))
    }

    @PatchMapping("/{id}")
    fun patchUser(@PathVariable id: String, @RequestBody userPatchDTO: UserPatchDTO): ResponseEntity<UserResponseDTO> {
        return ResponseEntity.ok(userService.patchUser(userPatchDTO, id))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Void> {
        return if (userService.deleteUser(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}
