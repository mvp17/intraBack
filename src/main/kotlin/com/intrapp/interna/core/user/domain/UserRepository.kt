package com.intrapp.interna.core.user.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {
    @Query("select u from User u where u.email = ?1")
    fun findByEmail(email: String): Optional<User>
}
