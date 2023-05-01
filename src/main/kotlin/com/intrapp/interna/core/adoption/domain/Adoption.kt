package com.intrapp.interna.core.adoption.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType


@Entity
@Table(name = "adoptions")
data class Adoption(
    @Column(name = "adoption_date")
    var adoptionDate: String,

    @Column(name = "godfather_id")
    var godfatherId: Long,

    @Column(name = "distance_godfather")
    var distance: Float,

    @Column(name = "representative_id")
    var representativeId: Long,

    @Column(name = "tree_id")
    var treeId: Long,

    @Column(name = "district")
    var district: String,

    @Column(name = "neigh")
    var neigh: String,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
