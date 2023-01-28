package com.intrapp.interna.entities.godfather.application

import com.intrapp.interna.entities.godfather.domain.Godfather
import com.intrapp.interna.entities.godfather.domain.SearchByGodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByGender(private val searchByGodfatherRepo: SearchByGodfatherRepo) {
    fun findGodfathersByGender(gender: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByGender(gender)
    }

    fun findGodfathersByGenderAndBirthdayFromDate(gender: String, fromDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByGenderAndBirthdayFromDate(gender, fromDate)
    }

    fun findGodfathersByGenderAndBirthdayToDate(gender: String, toDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByGenderAndBirthdayToDate(gender, toDate)
    }

    fun findGodfathersByGenderAndBirthdayFromDateAndBirthdayToDate(
        gender: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return searchByGodfatherRepo
            .findGodfathersByGenderAndBirthdayFromDateAndBirthdayToDate(
                gender, fromDate, toDate
            )
    }
}
