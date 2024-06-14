package com.onlineclass.dto

data class UserDTO(
    val email: String,
    val firstName: String,
    val middleName: String?,
    val lastName: String
)