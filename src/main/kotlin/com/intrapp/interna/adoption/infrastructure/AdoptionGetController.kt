package com.intrapp.interna.adoption.infrastructure

import com.intrapp.interna.adoption.application.AdoptionSearchService
import com.intrapp.interna.adoption.domain.Adoption
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/adoptions"])
class AdoptionGetController(private val adoptionSearchService: AdoptionSearchService) {
    @GetMapping
    fun findAdoptions(): List<Adoption> {
        return adoptionSearchService.findAdoptions()
    }

    @GetMapping("/{id}")
    fun findAdoptionByID(@PathVariable id: Long): Adoption {
        return adoptionSearchService.findAdoptionByID(id)
    }
}
