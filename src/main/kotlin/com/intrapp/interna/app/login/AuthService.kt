package com.intrapp.interna.app.login

import com.intrapp.interna.config.jwt.JwtService
import com.intrapp.interna.config.user.User
import com.intrapp.interna.config.user.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
)
{
    fun register(request: RegisterRequest): AuthenticationResponse {
        val user = User(request.username, request.email, passwordEncoder.encode(request.password), 0)
        userRepository.save(user)
        val token = jwtService.generateToken(user.username)
        return AuthenticationResponse(token)
    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email,
                request.password
            )
        )
        val user = userRepository.findByEmail(request.email).orElseThrow()
        val token = jwtService.generateToken(user.username)
        return AuthenticationResponse(token)
    }
}
