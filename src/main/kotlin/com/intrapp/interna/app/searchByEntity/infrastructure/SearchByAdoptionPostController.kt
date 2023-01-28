package com.intrapp.interna.app.searchByEntity.infrastructure

import com.intrapp.interna.app.searchByEntity.application.FilterUtils
import com.intrapp.interna.app.searchByEntity.application.SearchByAdoption
import com.intrapp.interna.app.searchByEntity.application.SearchByGodfather
import com.intrapp.interna.app.searchByEntity.domain.FilterJSONAdoptionDTO
import com.intrapp.interna.app.searchByEntity.domain.ResponseDTO
import com.intrapp.interna.app.searchByEntity.domain.TableDataResultsDTO
import com.intrapp.interna.entities.adoption.domain.Adoption
import com.intrapp.interna.entities.tree.application.TreeSearch
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/searchByAdoption"])
class SearchByAdoptionPostController(
    private val searchByGodfather: SearchByGodfather,
    private val searchByAdoption: SearchByAdoption,
    private val filterUtils: FilterUtils,
    private val treeService: TreeSearch
    ) {
    @PostMapping
    fun getAllAdoptionsByAdoption(@RequestBody filter: FilterJSONAdoptionDTO): ResponseDTO {
        val tableDataResultsList: MutableList<TableDataResultsDTO> = mutableListOf()
        val adoptions = getAdoptionsByFilter(filter)
        if (adoptions.isNotEmpty())
            for (adoption in adoptions) {
                val godfather = searchByGodfather.searchGodfatherById.findGodfatherById(adoption.godfatherId)
                val tree = treeService.findTreeById(adoption.treeId)
                val tableDataResultsDTO = TableDataResultsDTO(adoption.adoptionDate,
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
        val totalRecords = tableDataResultsList.size
        return ResponseDTO(tableDataResultsList, totalRecords)
    }

    fun getAdoptionsByFilter(filter: FilterJSONAdoptionDTO): List<Adoption> {
        val adoptions: MutableList<Adoption> = mutableListOf()

        if (filter.hasAdoptionId()) {
            adoptions.add(searchByAdoption.searchAdoptionById.findAdoptionById(filter.adoptionId!!.toLong()))
            return adoptions
        }

        if (!filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            return filterUtils.filterWhenNoDates(filter, adoptions)
        else if (filter.hasTreeName()       ||
            filter.hasTreeSpecies()         ||
            filter.hasAdoptionDistrict()    ||
            filter.hasAdoptionNeigh())
        {
            filterUtils.filterWhenTreeNameAndDates(filter, adoptions)
            filterUtils.filterWhenTreeSpeciesAndDates(filter, adoptions)
            filterUtils.filterWhenDistrictAndDates(filter, adoptions)
            filterUtils.filterWhenNeighAndDates(filter, adoptions)
            return adoptions.distinct()
        }
        else {
            return filterUtils.filterWhenOnlyDates(filter, adoptions)
        }
    }
}
