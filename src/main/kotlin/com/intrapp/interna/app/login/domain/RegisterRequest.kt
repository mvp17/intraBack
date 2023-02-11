package com.intrapp.interna.app.login.domain

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)
