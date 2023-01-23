package com.intrapp.interna.adoptions.domain.dtos

data class TableDataResults(
    var adoptionDate: String,
    val adoptionID: Long,
    val godfatherName: String,
    val godfatherGender: String,
    val godfatherBirthday: String,
    val treeName: String,
    val treeSpecies: String,
    val adoptionDistrict: String,
    val adoptionNeigh: String
)
