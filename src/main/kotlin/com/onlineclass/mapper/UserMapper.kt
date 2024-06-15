package com.onlineclass.mapper

import com.onlineclass.dto.UserCreateDTO
import com.onlineclass.dto.UserDTO
import com.onlineclass.dto.UserUpdateDTO
import com.onlineclass.model.User
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy
import org.springframework.stereotype.Component

@Component
@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface UserMapper {
    fun toEntity(dto: UserCreateDTO): User

    fun toDTO(user: User): UserDTO

    fun update(dto: UserUpdateDTO, @MappingTarget user: User)
}