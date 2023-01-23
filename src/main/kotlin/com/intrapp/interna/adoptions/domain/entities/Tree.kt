package com.intrapp.interna.adoptions.domain.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@Table(name = "tree")
data class Tree(
    @Column(name = "codigo_posicion_arbolada")
    var treePositionID: Int,

    @Column(name = "coordenada_x")
    var xCoord: Double,

    @Column(name = "coordenada_y")
    var yCoord: Double,

    @Column(name = "nombre_comun")
    var commonName: String,

    @Column(name = "especie")
    var species: String,

    @Column(name = "distancia_padrino")
    var godfatherDistance: String,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
