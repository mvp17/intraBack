package com.intrapp.interna.adoptions.infrastructure

import com.intrapp.interna.adoptions.application.SearchByGodfatherService
import com.intrapp.interna.adoptions.domain.dtos.FilterJSONGodfather
import com.intrapp.interna.adoptions.domain.dtos.SearchByEntityResponse
import com.intrapp.interna.adoptions.domain.dtos.TableDataResults
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/searchByGodfather"])
class SearchByGodfatherPostController(private val searchByGodfatherService: SearchByGodfatherService) {

    @PostMapping
    fun getAllAdoptionsByGodfather(@RequestBody filter: FilterJSONGodfather):
            SearchByEntityResponse {
        val tableDataResultsList: MutableList<TableDataResults> = mutableListOf()

        val godfathers = searchByGodfatherService.searchByGodfatherName(filter.name)
        for (godfather in godfathers) {
            val adoptions = searchByGodfatherService.getAllAdoptionsFromGodfather(godfather.id)
            for (adoption in adoptions) {
                val tree = searchByGodfatherService.getTreeFromAdoptionTreeID(adoption.treeId)
                val tableDataResultsDTO = TableDataResults(adoption.adoptionDate,
                                                           adoption.id,
                                                           godfather.name,
                                                           godfather.gender,
                                                           godfather.birthday,
                                                           tree.commonName,
                                                           tree.species,
                                                           adoption.district,
                                                           adoption.neigh)
                tableDataResultsList.add(tableDataResultsDTO)
            }
        }
        val totalRecords: Int = tableDataResultsList.size
        return SearchByEntityResponse(tableDataResultsList, totalRecords)
    }
}