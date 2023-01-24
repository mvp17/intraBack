package com.intrapp.interna.entities.padronAddress.application

import com.intrapp.interna.entities.padronAddress.domain.CensusAddress
import com.intrapp.interna.entities.padronAddress.domain.CensusAddressRepository
import org.springframework.stereotype.Service

@Service
class CensusAddressSearch(private val censusAddressRepository: CensusAddressRepository) {

    fun findCensusAddressByRepresentativeId(id: Long): CensusAddress {
        return censusAddressRepository.findCensusAddressByRepresentativeId(id)
    }

}