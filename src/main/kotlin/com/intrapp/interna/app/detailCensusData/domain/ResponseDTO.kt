package com.intrapp.interna.app.detailCensusData.domain

import com.intrapp.interna.entities.consent.domain.Consent
import com.intrapp.interna.entities.godfather.domain.Godfather
import com.intrapp.interna.entities.representative.domain.Representative

data class ResponseDTO(
    val godfather: Godfather,
    val representative: Representative,
    val adoption: AdoptionDTO,
    val tree: TreeDTO,
    val consent: Consent,
    val censusAddress: CensusAddressDTO,
    val bdcLocation: BDCLocationDTO
)
