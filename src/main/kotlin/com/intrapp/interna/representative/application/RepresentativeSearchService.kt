package com.intrapp.interna.representative.application

import com.intrapp.interna.representative.domain.Representative
import com.intrapp.interna.representative.domain.RepresentativeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.ResponseStatusException

@Service
class RepresentativeSearchService(private val representativeRepository: RepresentativeRepository) {
    @GetMapping
    fun findRepresentatives(): List<Representative> {
        return representativeRepository.findAll()
    }

    @GetMapping
    fun findRepresentativeByID(id:Long): Representative {
        return representativeRepository.findById(id).orElseThrow { throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Representative not found!")
        }
    }
}
