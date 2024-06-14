package com.onlineclass.service

import com.onlineclass.dto.UserCreateDTO
import com.onlineclass.dto.UserDTO
import com.onlineclass.dto.UserUpdateDTO
import com.onlineclass.exception.ResourceNotFoundException
import com.onlineclass.mapper.UserMapper
import com.onlineclass.model.User
import com.onlineclass.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) {

    fun getAll(): List<UserDTO> = userRepository.findAll().map { userMapper.toDTO(it) }

    fun getById(id: Long): UserDTO = userMapper.toDTO(getUserEntityById(id))

    fun create(dto: UserCreateDTO): UserDTO {
        val user = userRepository.save(userMapper.toEntity(dto))
        return userMapper.toDTO(user)
    }

    fun update(dto: UserUpdateDTO, id: Long): UserDTO {
        val user = getUserEntityById(id)
        userMapper.update(dto, user)
        return userMapper.toDTO(userRepository.save(user))
    }

    private fun getUserEntityById(id: Long): User = userRepository.findById(id)
        .orElseThrow { ResourceNotFoundException("User with id $id not found") }
}