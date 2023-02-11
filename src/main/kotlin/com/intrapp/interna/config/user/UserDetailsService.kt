package com.intrapp.interna.config.user

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.Collections

@Service
class UserDetailsService (
    private val repository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findByEmail(username).orElseThrow()
            ?: throw UsernameNotFoundException("$username not found")
        return UserSecurity(
            user.id,
            user.email,
            user.pass_word,
            Collections.singleton(SimpleGrantedAuthority("user"))
        )
    }
}
