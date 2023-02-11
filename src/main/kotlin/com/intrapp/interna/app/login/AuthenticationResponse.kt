package com.intrapp.interna.app.login

import java.beans.ConstructorProperties

data class AuthenticationResponse
@ConstructorProperties("token")
constructor(val token: String)
