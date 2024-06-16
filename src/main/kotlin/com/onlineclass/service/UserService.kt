package com.onlineclass.service

import com.onlineclass.dto.UserCreateDTO
import com.onlineclass.dto.UserDTO
import com.onlineclass.dto.UserUpdateDTO
import com.onlineclass.exception.ResourceNotFoundException
import com.onlineclass.mapper.UserMapper
import com.onlineclass.repository.UserRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) {

    fun create(dto: UserCreateDTO): UserDTO {
        val user = userRepository.save(userMapper.toEntity(dto))
        return userMapper.toDTO(user)
    }

    fun update(dto: UserUpdateDTO, id: Long): UserDTO {
        val user = userRepository.findById(id)
            .orElseThrow {
                val notFoundMessage = "User with id $id not found"
                logger.info { notFoundMessage }
                throw ResourceNotFoundException(notFoundMessage)
            }
        userMapper.update(dto, user)
        return userMapper.toDTO(userRepository.save(user))
    }

    fun assignRole(email: String, roleId: Int) {
        val user = userRepository.findByEmail(email)
        user.roleId = roleId
        userRepository.save(user)
    }
}