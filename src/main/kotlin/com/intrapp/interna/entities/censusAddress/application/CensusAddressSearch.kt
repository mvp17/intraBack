package com.intrapp.interna.entities.censusAddress.application

import com.intrapp.interna.entities.censusAddress.domain.CensusAddress
import com.intrapp.interna.entities.censusAddress.domain.CensusAddressRepository
import org.springframework.stereotype.Service

@Service
class CensusAddressSearch(private val censusAddressRepository: CensusAddressRepository) {

    fun findCensusAddressByRepresentativeId(id: Long): CensusAddress {
        return censusAddressRepository.findCensusAddressByRepresentativeId(id)
    }

}