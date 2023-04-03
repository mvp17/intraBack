package com.intrapp.interna.modules.detailCensusData.domain

import com.intrapp.interna.core.consent.domain.Consent
import com.intrapp.interna.core.godfather.domain.Godfather
import com.intrapp.interna.core.representative.domain.Representative

data class ResponseDTO(
    val godfather: Godfather,
    val representative: Representative,
    val adoption: AdoptionDTO,
    val tree: TreeDTO,
    val consent: Consent,
    val censusAddress: CensusAddressDTO,
    val bdcLocation: BDCLocationDTO
)
