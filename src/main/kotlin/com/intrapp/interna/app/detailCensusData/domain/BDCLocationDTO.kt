package com.intrapp.interna.app.detailCensusData.domain

data class BDCLocationDTO(
    val streetType: String,
    val streetName: String,
    val streetNumber: String,
    val staircase: String,
    val floor: String,
    val door: String,
    val zipCode: String,
    val ndpBDCClass: String,
    val ndp: String,
    val xCoord: Number,
    val yCoord: Number,
    val district: String,
    val neigh: String
)
