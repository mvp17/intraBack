package com.intrapp.interna.representative.infrastructure

import com.intrapp.interna.representative.application.RepresentativeSearchService
import com.intrapp.interna.representative.domain.Representative
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/representatives"])
class RepresentativeGetController(private val representativeSearchService: RepresentativeSearchService) {
    @GetMapping
    fun findRepresentatives(): List<Representative> {
        return representativeSearchService.findRepresentatives()
    }

    @GetMapping("/{id}")
    fun findRepresentativeByID(@PathVariable id: Long): Representative {
        return representativeSearchService.findRepresentativeByID(id)
    }
}
