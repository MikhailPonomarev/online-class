package com.onlineclass.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

data class UserUpdateDTO(
    @field:Email
    val email: String?,

    @field:Size(min = 2)
    val firstName: String?,

    @field:Size(min = 2)
    val lastName: String?
)
