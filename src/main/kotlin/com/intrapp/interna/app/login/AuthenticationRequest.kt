package com.intrapp.interna.app.login

import java.beans.ConstructorProperties

data class AuthenticationRequest
@ConstructorProperties("email", "password")
constructor(val email: String, val password: String)
