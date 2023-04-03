package com.intrapp.interna.core.adoption.application

import com.intrapp.interna.core.adoption.domain.Adoption
import com.intrapp.interna.core.adoption.domain.repositories.SearchByAdoptionRepo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SearchAdoptionById(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    fun findAdoptionById(id: Long): Adoption {
        return searchByAdoptionRepo.findById(id)
            .orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Adoption not found!")
            }
    }
    fun findAdoptionsByGodfatherId(id: Long): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByGodfatherId(id)
    }
}
