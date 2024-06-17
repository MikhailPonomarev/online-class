package com.onlineclass.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserCreateDTO(
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Size(min = 2)
    val firstName: String,

    @field:NotBlank
    @field:Size(min = 2)
    val lastName: String,

    @field:NotBlank
    val role: String
)
