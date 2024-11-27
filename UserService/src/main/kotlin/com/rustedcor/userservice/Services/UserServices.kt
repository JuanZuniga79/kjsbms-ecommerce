package com.rustedcor.userservice.Services

import com.rustedcor.userservice.DTO.UserEditDTO
import com.rustedcor.userservice.DTO.UserPatchDTO
import com.rustedcor.userservice.DTO.UserResponseDTO
import com.rustedcor.userservice.DTO.UserSaveDTO
import com.rustedcor.userservice.Mappers.RoleMapper.toRole
import com.rustedcor.userservice.Mappers.UserMapper
import com.rustedcor.userservice.Mappers.UserMapper.toUser
import com.rustedcor.userservice.Mappers.UserMapper.toUserResponseDTO
import com.rustedcor.userservice.Models.User
import com.rustedcor.userservice.Repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServices (private val _roleService: RoleServices, private val _repository: UserRepository){

    fun createUser(user: UserSaveDTO): UserResponseDTO {
        val role = _roleService.getRoleById(user.roleId);
        val newUser: User = user.toUser(role.toRole());
        return _repository.save(newUser).toUserResponseDTO();
    }

    fun getUserById(userId: String): UserResponseDTO {
        val id = UUID.fromString(userId);
        val user = _repository.findById(id).orElseThrow {
            throw IllegalArgumentException("User not found with id: $userId")
        }
        return user.toUserResponseDTO();
    }

    fun getAllUsers(): MutableList<UserResponseDTO> {
        val users = _repository.getAllUsers();
        if(users.isEmpty()) return mutableListOf();
        val newUsers: MutableList<UserResponseDTO> = mutableListOf();
        for (user in users) {
            newUsers.add(user.toUserResponseDTO());
        }
        return newUsers;
    }

    fun putUser(user: UserEditDTO, id: String): UserResponseDTO {
        val newId = UUID.fromString(id)
        val existingUser = _repository.findById(newId).orElseThrow {
            throw IllegalArgumentException("User with ID $id not found")
        }

        val role = _roleService.getRoleById(user.roleId)

        existingUser.apply {
            firstName = user.firstName ?: firstName
            lastName = user.lastName ?: lastName
            email = user.email ?: email
            this.role = role.toRole()
        }

        return _repository.save(existingUser).toUserResponseDTO();
    }

    fun patchUser(userPatchDTO: UserPatchDTO, id: String): UserResponseDTO {
        val newId = UUID.fromString(id)

        val existingUser = _repository.findById(newId).orElseThrow {
            throw IllegalArgumentException("User with ID $id not found")
        }

        existingUser.apply {
            userPatchDTO.firstName?.let { firstName = it }
            userPatchDTO.lastName?.let { lastName = it }
            userPatchDTO.email?.let { email = it }
            userPatchDTO.roleId?.let {
                val role = _roleService.getRoleById(it)
                this.role = role.toRole()
            }
        }

        return _repository.save(existingUser).toUserResponseDTO();
    }

    fun deleteUser(userId: String): Boolean{
        val id = UUID.fromString(userId)
        val user = _repository.findById(id).orElseThrow {
            throw IllegalArgumentException("User with ID $userId not found")
        }
        _repository.delete(user)
        return true
    }

}