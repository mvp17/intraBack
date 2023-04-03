package com.intrapp.interna.modules.login.domain

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)
