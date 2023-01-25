package com.intrapp.interna.app.searchByEntity.infrastructure

import com.intrapp.interna.entities.adoption.application.AdoptionSearch
import com.intrapp.interna.entities.godfather.application.GodfatherSearch
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
    private val godfatherService: GodfatherSearch,
    private val adoptionService: AdoptionSearch,
    private val treeService: TreeSearch
    ) {
    @PostMapping
    fun getAllAdoptionsByAdoption(@RequestBody filter: FilterJSONAdoptionDTO): ResponseDTO {
        val tableDataResultsList: MutableList<TableDataResultsDTO> = mutableListOf()
        val adoptions = getAdoptionsByFilter(filter)
        if (adoptions.isNotEmpty())
            for (adoption in adoptions) {
                val godfather = godfatherService.findGodfatherById(adoption.godfatherId)
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
            adoptions.add(adoptionService.findAdoptionById(filter.adoptionId!!.toLong()))
            return adoptions
        }

        if (!filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            return filterWhenNoDates(filter, adoptions)
        else if (filter.hasTreeName()       ||
            filter.hasTreeSpecies()         ||
            filter.hasAdoptionDistrict()    ||
            filter.hasAdoptionNeigh())
        {
            filterWhenTreeNameAndDates(filter, adoptions)
            filterWhenTreeSpeciesAndDates(filter, adoptions)
            filterWhenDistrictAndDates(filter, adoptions)
            filterWhenNeighAndDates(filter, adoptions)
            return adoptions.distinct()
        }
        else {
            return filterWhenOnlyDates(filter, adoptions)
        }
    }

    fun filterWhenNoDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>): List<Adoption> {
        if (filter.hasTreeName())
            adoptions.addAll(adoptionService.
            findAdoptionsByTreeName(filter.treeName!!))
        if (filter.hasTreeSpecies())
            adoptions.addAll(adoptionService.
            findAdoptionsByTreeSpecies(filter.treeSpecies!!))
        if (filter.hasAdoptionDistrict())
            adoptions.addAll(adoptionService.findAdoptionsByDistrict(filter.adoptionDistrict!!))
        if (filter.hasAdoptionNeigh())
            adoptions.addAll(adoptionService.findAdoptionsByNeigh(filter.adoptionNeigh!!))
        return adoptions.distinct()
    }
    fun filterWhenTreeNameAndDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>) {
        // treeName + adoptionFromDate
        if (filter.hasTreeName() and filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByTreeNameAndAdoptionFromDate(
                filter.treeName!!,
                filter.adoptionFromDate!!
            ))
        // treeName + adoptionToDate
        else if (filter.hasTreeName() and filter.hasAdoptionToDate() and !filter.hasAdoptionFromDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByTreeNameAndAdoptionToDate(
                filter.treeName!!,
                filter.adoptionToDate!!
            ))
        // treeName + adoptionFromDate + adoptionToDate
        else if (filter.hasTreeName() and filter.hasAdoptionFromDate() and filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByTreeNameAndAdoptionFromDateAndAdoptionToDate(
                filter.treeName!!,
                filter.adoptionFromDate!!,
                filter.adoptionToDate!!
            ))
    }
    fun filterWhenTreeSpeciesAndDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>) {
        // treeSpecies + adoptionFromDate
        if (filter.hasTreeSpecies() and filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByTreeSpeciesAndAdoptionFromDate(
                filter.treeSpecies!!,
                filter.adoptionFromDate!!
            ))
        // treeSpecies + adoptionToDate
        else if (filter.hasTreeSpecies() and filter.hasAdoptionToDate() and !filter.hasAdoptionFromDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByTreeSpeciesAndAdoptionToDate(
                filter.treeSpecies!!,
                filter.adoptionToDate!!
            ))
        // treeSpecies + adoptionFromDate + adoptionToDate
        else if (filter.hasTreeSpecies() and filter.hasAdoptionFromDate() and filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
                filter.treeSpecies!!,
                filter.adoptionFromDate!!,
                filter.adoptionToDate!!
            ))
    }
    fun filterWhenDistrictAndDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>) {
        // district + adoptionFromDate
        if (filter.hasAdoptionDistrict() and filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByDistrictAndAdoptionFromDate(
                filter.adoptionDistrict!!,
                filter.adoptionFromDate!!
            ))
        // district + adoptionToDate
        else if (filter.hasAdoptionDistrict() and filter.hasAdoptionToDate() and !filter.hasAdoptionFromDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByDistrictAndAdoptionToDate(
                filter.adoptionDistrict!!,
                filter.adoptionToDate!!
            ))
        // district + adoptionFromDate + adoptionToDate
        else if (filter.hasAdoptionDistrict() and filter.hasAdoptionFromDate() and filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
                filter.adoptionDistrict!!,
                filter.adoptionFromDate!!,
                filter.adoptionToDate!!
            ))
    }
    fun filterWhenNeighAndDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>) {
        // neigh + adoptionFromDate
        if (filter.hasAdoptionNeigh() and filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByNeighAndAdoptionFromDate(
                filter.adoptionNeigh!!,
                filter.adoptionFromDate!!
            ))
        // neigh + adoptionToDate
        else if (filter.hasAdoptionNeigh() and filter.hasAdoptionToDate() and !filter.hasAdoptionFromDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByNeighAndAdoptionToDate(
                filter.adoptionNeigh!!,
                filter.adoptionToDate!!
            ))
        // neigh + adoptionFromDate + adoptionToDate
        else if (filter.hasAdoptionNeigh() and filter.hasAdoptionFromDate() and filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.
            findAdoptionsByNeighAndAdoptionFromDateAndAdoptionToDate(
                filter.adoptionNeigh!!,
                filter.adoptionFromDate!!,
                filter.adoptionToDate!!
            ))
    }
    fun filterWhenOnlyDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>): List<Adoption> {
        if (filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            adoptions.addAll(adoptionService.findAdoptionsByAdoptionFromDate(filter.adoptionFromDate!!))
        else if (filter.hasAdoptionToDate() and !filter.hasAdoptionFromDate())
            adoptions.addAll(adoptionService.findAdoptionsByAdoptionToDate(filter.adoptionToDate!!))
        else
            adoptions.addAll(adoptionService.findAdoptionsByAdoptionFromDateAndAdoptionToDate(
                filter.adoptionFromDate!!,
                filter.adoptionToDate!!
            ))
        return adoptions.distinct()
    }
}
