package com.intrapp.interna.godfather.infrastructure

import com.intrapp.interna.godfather.application.GodfatherSearchService
import com.intrapp.interna.godfather.domain.Godfather
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/godfathers"])
class GodfatherGetController(private val godfatherSearchService: GodfatherSearchService) {
    @GetMapping
    fun findGodfathers(): List<Godfather> {
        return godfatherSearchService.findGodfathers()
    }

    @GetMapping("/{id}")
    fun findGodfather(@PathVariable id: Long): Godfather {
        return godfatherSearchService.findGodfatherByID(id)
    }
}
