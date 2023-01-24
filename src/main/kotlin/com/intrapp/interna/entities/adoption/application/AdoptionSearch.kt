package com.intrapp.interna.entities.adoption.application

import com.intrapp.interna.entities.adoption.domain.Adoption
import com.intrapp.interna.entities.adoption.domain.AdoptionRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AdoptionSearch(private val adoptionRepository: AdoptionRepository) {

    fun findAdoptionsByGodfatherId(id: Long): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByGodfatherId(id)
    }

    fun findAdoptionsByTreeName(name: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeName(name)
    }

    fun findAdoptionById(id: Long): Adoption {
        return adoptionRepository.findById(id)
            .orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Adoption not found!")
            }
    }

}
