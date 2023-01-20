package com.intrapp.interna.adoption.application

import com.intrapp.interna.adoption.domain.Adoption
import com.intrapp.interna.adoption.domain.AdoptionRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.ResponseStatusException

@Service
class AdoptionSearchService(private val adoptionRepository: AdoptionRepository) {
    @GetMapping
    fun findAdoptions(): List<Adoption> {
        return adoptionRepository.findAll()
    }

    @GetMapping
    fun findAdoptionByID(id:Long): Adoption {
        return adoptionRepository.findById(id).orElseThrow { throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Adoption not found!")
        }
    }
}
