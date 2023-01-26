package com.intrapp.interna.entities.adoption.application

import com.intrapp.interna.entities.adoption.domain.Adoption
import com.intrapp.interna.entities.adoption.domain.SearchByAdoptionRepo
import org.springframework.stereotype.Service

@Service
class SearchAdoptionByDates(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    fun findAdoptionsByAdoptionFromDate(date: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByFromDate(date)
    }
    fun findAdoptionsByAdoptionToDate(date: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByToDate(date)
    }
    fun findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate: String, toDate: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate, toDate)
    }
}
