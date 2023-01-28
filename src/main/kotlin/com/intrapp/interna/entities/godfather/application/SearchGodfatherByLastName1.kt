package com.intrapp.interna.entities.godfather.application

import com.intrapp.interna.entities.godfather.domain.Godfather
import com.intrapp.interna.entities.godfather.domain.SearchByGodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByLastName1(private val searchByGodfatherRepo: SearchByGodfatherRepo) {
    fun findGodfathersByLastName1(lastName1: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByLastName1(lastName1)
    }
    fun findGodfathersByLastName1AndBirthdayFromDate(lastName1: String, fromDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByLastName1AndAndBirthdayFromDate(lastName1, fromDate)
    }
    fun findGodfathersByLastName1AndBirthdayToDate(lastName1: String, toDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByLastName1AndAndBirthdayToDate(lastName1, toDate)
    }
    fun findGodfathersByLastName1AndBirthdayFromDateAndBirthdayToDate(
        lastName1: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return searchByGodfatherRepo
            .findGodfathersByLastName1AndBirthdayFromDateAndAndBirthdayToDate(
                lastName1, fromDate, toDate
            )
    }
}
