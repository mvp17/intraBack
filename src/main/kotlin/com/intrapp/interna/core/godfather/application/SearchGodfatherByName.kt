package com.intrapp.interna.core.godfather.application

import com.intrapp.interna.core.godfather.domain.Godfather
import com.intrapp.interna.core.godfather.domain.repositories.SearchByGodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByName(private val searchByGodfatherRepo: SearchByGodfatherRepo) {
    fun findGodfathersByName(name: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByName(name)
    }
    fun findGodfathersByNameAndBirthdayFromDate(name: String, fromDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByNameAndBirthdayFromDate(name, fromDate)
    }
    fun findGodfathersByNameAndBirthdayToDate(name: String, toDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByNameAndBirthdayToDate(name, toDate)
    }
    fun findGodfathersByNameAndBirthdayFromDateAndBirthdayToDate(
        name: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByNameAndBirthdayFromDateAndBirthdayToDate(name, fromDate, toDate)
    }
}
