package com.intrapp.interna.godfather.application

import com.intrapp.interna.godfather.domain.Godfather
import com.intrapp.interna.godfather.domain.GodfatherRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.ResponseStatusException

@Service
class GodfatherSearchService(private val godfatherRepository: GodfatherRepository) {
    @GetMapping
    fun findGodfathers(): List<Godfather> {
        return godfatherRepository.findAll()
    }

    @GetMapping
    fun findGodfatherByID(id:Long): Godfather {
        return godfatherRepository.findById(id).orElseThrow { throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Godfather not found!")
        }
    }
}
