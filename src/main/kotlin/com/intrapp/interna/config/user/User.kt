package com.intrapp.interna.config.user

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Collections

@Entity
@Table(name = "usuarios")
data class User(
    @Column(name = "username")
    val name: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "passw")
    var pass_word: String,

    @Id
    @SequenceGenerator(name = "\"usuarios_id_seq\"", allocationSize = 1)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "\"usuarios_id_seq\""
    )
    @Column(name = "id")
    val id: Long
)
