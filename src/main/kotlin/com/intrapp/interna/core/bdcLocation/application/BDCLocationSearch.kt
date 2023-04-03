package com.intrapp.interna.core.bdcLocation.application

import com.intrapp.interna.core.bdcLocation.domain.BDCLocation
import com.intrapp.interna.core.bdcLocation.domain.BDCLocationRepository
import org.springframework.stereotype.Service

@Service
class BDCLocationSearch(private val bdcLocationRepository: BDCLocationRepository) {

    fun findBDCLocationByRepresentativeId(id: Long): BDCLocation {
        return bdcLocationRepository.findBDCLocationByRepresentativeId(id)
    }
}