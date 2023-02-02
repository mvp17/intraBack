package com.intrapp.interna.entities.adoption.application

import com.intrapp.interna.entities.adoption.domain.Adoption
import com.intrapp.interna.entities.adoption.domain.SearchByAdoptionRepo
import org.springframework.stereotype.Service

@Service
class SearchAdoptionByTreeName(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    fun findAdoptionsByTreeName(name: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeName(name)
    }
    fun findAdoptionsByTreeNameAndAdoptionFromDate(
        treeName: String, fromDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeNameAndAdoptionFromDate(
            treeName, fromDate
        )
    }
    fun findAdoptionsByTreeNameAndAdoptionToDate(
        treeName: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeNameAndAdoptionToDate(
            treeName, toDate
        )
    }
    fun findAdoptionsByTreeNameAndAdoptionFromDateAndAdoptionToDate(
        treeName: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeNameAndAdoptionFromDateAndAdoptionToDate(
            treeName, fromDate, toDate
        )
    }
}
