package com.onlineclass.controller

import com.onlineclass.dto.UserCreateDTO
import com.onlineclass.dto.UserDTO
import com.onlineclass.dto.UserUpdateDTO
import com.onlineclass.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController(
    private val userService: UserService
) {

    @GetMapping
    fun index(): List<UserDTO> = userService.getAll()

    @GetMapping("/{id}")
    fun show(@PathVariable id: Long): UserDTO = userService.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: UserCreateDTO): UserDTO = userService.create(dto)

    @PutMapping("/{id}")
    fun update(@RequestBody dto: UserUpdateDTO, @PathVariable id: Long): UserDTO = userService.update(dto, id)
}