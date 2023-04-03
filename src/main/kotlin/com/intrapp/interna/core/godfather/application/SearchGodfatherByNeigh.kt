package com.intrapp.interna.core.godfather.application

import com.intrapp.interna.core.godfather.domain.Godfather
import com.intrapp.interna.core.godfather.domain.repositories.SearchByGodfatherNeighRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByNeigh(private val searchByGodfatherRepo: SearchByGodfatherNeighRepo) {
    fun findGodfathersByNeigh(neigh: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByNeigh(neigh)
    }

    fun findGodfathersByNeighAndBirthdayFromDate(neigh: String, fromDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByNeighAndBirthdayFromDate(neigh, fromDate)
    }

    fun findGodfathersByNeighAndBirthdayToDate(neigh: String, toDate: String): MutableList<Godfather> {
        return searchByGodfatherRepo.findGodfathersByNeighAndBirthdayToDate(neigh, toDate)
    }

    fun findGodfathersByNeighAndBirthdayFromDateAndBirthdayToDate(
        neigh: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return searchByGodfatherRepo
            .findGodfathersByNeighAndBirthdayFromDateAndBirthdayToDate(
                neigh, fromDate, toDate
            )
    }
}
