package com.intrapp.interna.core.godfather.application

import com.intrapp.interna.core.godfather.domain.Godfather
import com.intrapp.interna.core.godfather.domain.repositories.SearchByGodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByBirthdayDates(private val searchByGodfatherRepo: SearchByGodfatherRepo) {
    fun findGodfathersByBirthdayFromDate(date: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByBirthdayFromDate(date)
    }

    fun findGodfathersByBirthdayToDate(date: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByBirthdayToDate(date)
    }

    fun findGodfathersByBirthdayFromDateAndBirthdayToDate(fromDate: String, toDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByBirthdayFromDateAndBirthdayToDate(fromDate, toDate)
    }
}
