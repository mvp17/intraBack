package com.intrapp.interna.app.login.infrastructure

import com.intrapp.interna.app.login.application.AuthService
import com.intrapp.interna.app.login.domain.AuthenticationRequest
import com.intrapp.interna.app.login.domain.AuthenticationResponse
import com.intrapp.interna.app.login.domain.RegisterRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/auth")
class AuthenticationController(private val authService: AuthService) {

    @PostMapping("/register")
    fun register(@RequestBody user: RegisterRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authService.register(user))
    }

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authService.authenticate(request))
    }
}
