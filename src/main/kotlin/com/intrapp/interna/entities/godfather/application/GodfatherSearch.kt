package com.intrapp.interna.entities.godfather.application

import com.intrapp.interna.entities.godfather.domain.Godfather
import com.intrapp.interna.entities.godfather.domain.GodfatherRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class GodfatherSearch(private val godfatherRepository: GodfatherRepository) {

    fun searchByGodfatherName(name: String): MutableList<Godfather> {
        return godfatherRepository.findGodfatherByName(name)
    }

    fun findGodfatherById(id: Long): Godfather {
        return godfatherRepository.findById(id)
            .orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Godfather not found!")
            }
    }

}
