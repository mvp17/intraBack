package com.intrapp.interna.app.searchByEntity.infrastructure

import com.intrapp.interna.app.searchByEntity.application.utils.AdoptionFilterUtils
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
    private val adoptionFilterUtils: AdoptionFilterUtils,
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
                val tableDataResultsDTO = TableDataResultsDTO(
                    adoption.adoptionDate,
                    adoption.id,
                    godfather.name,
                    godfather.gender,
                    godfather.birthday,
                    tree.commonName,
                    tree.species,
                    adoption.district,
                    adoption.neigh
                )
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

        return if (!filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            adoptionFilterUtils.filterWhenNoDates(filter, adoptions)
        else if (
            filter.hasTreeName()            or
            filter.hasTreeSpecies()         or
            filter.hasAdoptionDistrict()    or
            filter.hasAdoptionNeigh()
        ) {
            adoptionFilterUtils.filterWhenTreeNameAndDates(filter, adoptions)
            adoptionFilterUtils.filterWhenTreeSpeciesAndDates(filter, adoptions)
            adoptionFilterUtils.filterWhenDistrictAndDates(filter, adoptions)
            adoptionFilterUtils.filterWhenNeighAndDates(filter, adoptions)
            adoptions.distinct()
        } else adoptionFilterUtils.filterWhenOnlyDates(filter, adoptions)
    }
}
