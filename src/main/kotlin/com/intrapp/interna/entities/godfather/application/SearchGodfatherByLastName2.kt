package com.intrapp.interna.entities.godfather.application

import com.intrapp.interna.entities.godfather.domain.Godfather
import com.intrapp.interna.entities.godfather.domain.SearchByGodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByLastName2(private val searchByGodfatherRepo: SearchByGodfatherRepo) {
    fun findGodfathersByLastName2(lastName2: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByLastName2(lastName2)
    }

    fun findGodfathersByLastName2AndBirthdayFromDate(lastName2: String, fromDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByLastName2AndBirthdayFromDate(lastName2, fromDate)
    }

    fun findGodfathersByLastName2AndBirthdayToDate(lastName2: String, toDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByLastName2AndBirthdayToDate(lastName2, toDate)
    }

    fun findGodfathersByLastName2AndBirthdayFromDateAndBirthdayToDate(
        lastName2: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return searchByGodfatherRepo
            .findGodfathersByLastName2AndBirthdayFromDateAndBirthdayToDate(
                lastName2, fromDate, toDate
            )
    }
}
