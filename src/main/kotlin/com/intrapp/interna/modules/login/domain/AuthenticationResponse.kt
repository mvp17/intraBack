package com.intrapp.interna.modules.login.domain

import java.beans.ConstructorProperties

data class AuthenticationResponse
@ConstructorProperties("token")
constructor(val token: String)
