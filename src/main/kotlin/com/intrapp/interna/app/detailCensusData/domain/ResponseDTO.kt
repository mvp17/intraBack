package com.intrapp.interna.app.detailCensusData.domain

import com.intrapp.interna.entities.adoption.domain.Adoption
import com.intrapp.interna.entities.bdcLocation.domain.BDCLocation
import com.intrapp.interna.entities.consent.domain.Consent
import com.intrapp.interna.entities.godfather.domain.Godfather
import com.intrapp.interna.entities.padronAddress.domain.CensusAddress
import com.intrapp.interna.entities.representative.domain.Representative
import com.intrapp.interna.entities.tree.domain.Tree

data class ResponseDTO(
    val godfather: Godfather,
    val representative: Representative,
    val adoption: Adoption,
    val tree: Tree,
    val consent: Consent,
    val censusAddress: CensusAddress,
    val bdcLocation: BDCLocation
)
