package com.intrapp.interna.core.censusAddress.application

import com.intrapp.interna.core.censusAddress.domain.CensusAddress
import com.intrapp.interna.core.censusAddress.domain.CensusAddressRepository
import org.springframework.stereotype.Service

@Service
class CensusAddressSearch(private val censusAddressRepository: CensusAddressRepository) {

    fun findCensusAddressByRepresentativeId(id: Long): CensusAddress {
        return censusAddressRepository.findCensusAddressByRepresentativeId(id)
    }

}