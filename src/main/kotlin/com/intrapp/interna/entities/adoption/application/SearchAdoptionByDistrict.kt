package com.intrapp.interna.entities.adoption.application

import com.intrapp.interna.entities.adoption.domain.Adoption
import com.intrapp.interna.entities.adoption.domain.SearchByAdoptionAdoptionAdoptionAdoptionRepo
import org.springframework.stereotype.Service

@Service
class SearchAdoptionByDistrict(private val searchByAdoptionRepo: SearchByAdoptionAdoptionAdoptionAdoptionRepo) {
    fun findAdoptionsByDistrict(district: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByDistrict(district)
    }
    fun findAdoptionsByDistrictAndAdoptionFromDate(district: String, fromDate: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByDistrictAndAdoptionFromDate(district, fromDate)
    }
    fun findAdoptionsByDistrictAndAdoptionToDate(district: String, toDate: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByDistrictAndAdoptionToDate(district, toDate)
    }
    fun findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
        district: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
            district, fromDate, toDate)
    }
}
