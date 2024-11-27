package com.rustedcor.userservice.Services

import com.rustedcor.userservice.DTO.RoleResponseDTO
import com.rustedcor.userservice.DTO.RoleSaveDTO
import com.rustedcor.userservice.Mappers.RoleMapper.toRole
import com.rustedcor.userservice.Mappers.RoleMapper.toRoleResponseDTO
import com.rustedcor.userservice.Models.Role
import com.rustedcor.userservice.Repositories.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleServices(private val _repository: RoleRepository) {

    fun getRoleById(roleId: Int): RoleResponseDTO {
        return _repository.findRoleById(roleId).toRoleResponseDTO();
    }

    fun getAllRoles(): MutableList<RoleResponseDTO> {
        val roles = _repository.findAllRoles();
        if(roles.isEmpty()) return mutableListOf();
        val list = mutableListOf<RoleResponseDTO>();
        for (role in roles) {
            list.add(role.toRoleResponseDTO());
        }
        return list;
    }

    fun createRole(role: RoleSaveDTO): RoleResponseDTO {
        val newRole = _repository.save(role.toRole());
        return newRole.toRoleResponseDTO();
    }

    fun deleteRoleById(roleId: Int): Boolean {
        _repository.deleteById(roleId);
        return true;
    }

}