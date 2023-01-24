package com.intrapp.interna.adoption.application

import com.intrapp.interna.adoption.domain.Adoption
import com.intrapp.interna.adoption.domain.AdoptionRepository
import org.springframework.stereotype.Service

@Service
class AdoptionSearch(private val adoptionRepository: AdoptionRepository) {

    fun getAllAdoptionsFromGodfather(id: Long): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsFromGodfather(id)
    }
}
