package com.intrapp.interna.core.godfather.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType


@Entity
@Table(name = "godfathers")
data class Godfather(
    @Column(name = "name")
    var name: String,

    @Column(name = "last_name1")
    var lastName1: String,

    @Column(name = "last_name2")
    var lastName2: String,

    @Column(name = "gender")
    val gender: String,

    @Column(name = "birthday")
    var birthday: String,

    @Column(name = "district")
    val district: String,

    @Column(name = "neigh")
    val neigh: String,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
