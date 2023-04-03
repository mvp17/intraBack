package com.intrapp.interna.core.godfather.application

import com.intrapp.interna.core.godfather.domain.Godfather
import com.intrapp.interna.core.godfather.domain.repositories.SearchByGodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByDistrict(private val searchByGodfatherRepo: SearchByGodfatherRepo) {
    fun findGodfathersByDistrict(district: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByDistrict(district)
    }

    fun findGodfathersByDistrictAndBirthdayFromDate(district: String, fromDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByDistrictAndBirthdayFromDate(district, fromDate)
    }

    fun findGodfathersByDistrictAndBirthdayToDate(district: String, toDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByDistrictAndBirthdayToDate(district, toDate)
    }

    fun findGodfathersByDistrictAndBirthdayFromDateAndBirthdayToDate(
        district: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return searchByGodfatherRepo
            .findGodfathersByDistrictAndBirthdayFromDateAndBirthdayToDate(
                district, fromDate, toDate
            )
    }
}
