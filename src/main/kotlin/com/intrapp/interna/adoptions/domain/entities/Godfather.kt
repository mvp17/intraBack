package com.intrapp.interna.adoptions.domain.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType


@Entity
@Table(name = "godfather")
data class Godfather(
    @Column(name = "nombre")
    var name: String,

    @Column(name = "apellido1")
    var lastName1: String,

    @Column(name = "apellido2")
    var lastName2: String,

    @Column(name = "genero")
    val gender: String,

    @Column(name = "fecha_nacimiento")
    val birthday: String,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
