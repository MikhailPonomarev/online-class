package com.onlineclass.dto

data class UserCreateDTO(
    val email: String,
    val firstName: String,
    val middleName: String?,
    val lastName: String
)
