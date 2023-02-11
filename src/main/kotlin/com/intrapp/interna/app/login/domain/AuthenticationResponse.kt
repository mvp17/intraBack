package com.intrapp.interna.app.login.domain

import java.beans.ConstructorProperties

data class AuthenticationResponse
@ConstructorProperties("token")
constructor(val token: String)
