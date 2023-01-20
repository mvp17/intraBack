package com.intrapp.interna.representative.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "representative")
data class Representative(
    @Column(name = "nombre")
    var name: String,

    @Column(name = "apellido1")
    var lastName1: String,

    @Column(name = "apellido2")
    var lastName2: String,

    @Column(name = "nif_nie")
    val nifNie: String,

    @Column(name = "fecha_nacimiento")
    val birthday: String,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
