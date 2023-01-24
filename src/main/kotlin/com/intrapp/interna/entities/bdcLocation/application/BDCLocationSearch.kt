package com.intrapp.interna.entities.bdcLocation.application

import com.intrapp.interna.entities.bdcLocation.domain.BDCLocation
import com.intrapp.interna.entities.bdcLocation.domain.BDCLocationRepository
import org.springframework.stereotype.Service

@Service
class BDCLocationSearch(private val bdcLocationRepository: BDCLocationRepository) {

    fun findBDCLocationByRepresentativeId(id: Long): BDCLocation {
        return bdcLocationRepository.findBDCLocationByRepresentativeId(id)
    }
}