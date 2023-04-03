package com.intrapp.interna.core.godfather.application

import com.intrapp.interna.core.godfather.domain.Godfather
import com.intrapp.interna.core.godfather.domain.repositories.SearchByGodfatherRepo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SearchGodfatherById(private val searchByGodfatherRepo: SearchByGodfatherRepo) {
    fun findGodfatherById(id: Long): Godfather {
        return searchByGodfatherRepo.findById(id)
            .orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Godfather not found!")
            }
    }
}
