package com.intrapp.interna.entities.adoption.application

import com.intrapp.interna.entities.adoption.domain.Adoption
import com.intrapp.interna.entities.adoption.domain.SearchByAdoptionRepo
import org.springframework.stereotype.Service

@Service
class SearchAdoptionByTreeSpecies(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    fun findAdoptionsByTreeSpecies(treeSpecies: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeSpecies(treeSpecies)
    }
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDate(
        treeSpecies: String, fromDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeSpeciesAndAdoptionFromDate(treeSpecies, fromDate)
    }
    fun findAdoptionsByTreeSpeciesAndAdoptionToDate(
        treeSpecies: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeSpeciesAndAdoptionToDate(treeSpecies, toDate)
    }
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
        treeSpecies: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
            treeSpecies, fromDate, toDate
        )
    }
}
