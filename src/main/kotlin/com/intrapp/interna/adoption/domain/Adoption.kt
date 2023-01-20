package com.intrapp.interna.adoption.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType


@Entity
@Table(name = "adoption")
data class Adoption(
    @Column(name = "fecha_adopcion")
    var adoptionDate: String,

    @Column(name = "id_padrino")
    var godfatherId: Long,

    @Column(name = "id_representante")
    var representativeId: Long,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
