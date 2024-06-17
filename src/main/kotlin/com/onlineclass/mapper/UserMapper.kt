package com.onlineclass.mapper

import com.onlineclass.dto.UserCreateDTO
import com.onlineclass.dto.UserDTO
import com.onlineclass.dto.UserUpdateDTO
import com.onlineclass.model.User
import org.mapstruct.*
import org.springframework.stereotype.Component

@Component
@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface UserMapper {
    @Mapping(source = "role", target = "role.name")
    fun toEntity(dto: UserCreateDTO): User

    @Mapping(source = "role.name", target = "role")
    fun toDTO(user: User): UserDTO

    fun update(dto: UserUpdateDTO, @MappingTarget user: User)
}