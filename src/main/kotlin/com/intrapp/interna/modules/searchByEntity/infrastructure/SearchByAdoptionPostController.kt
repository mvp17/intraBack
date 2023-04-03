package com.intrapp.interna.modules.searchByEntity.infrastructure

import com.intrapp.interna.modules.searchByEntity.application.utils.AdoptionFilterUtils
import com.intrapp.interna.modules.searchByEntity.application.SearchByAdoption
import com.intrapp.interna.modules.searchByEntity.application.SearchByGodfather
import com.intrapp.interna.modules.searchByEntity.domain.FilterJSONAdoptionDTO
import com.intrapp.interna.modules.searchByEntity.domain.ResponseDTO
import com.intrapp.interna.modules.searchByEntity.domain.TableDataResultsDTO
import com.intrapp.interna.core.adoption.domain.Adoption
import com.intrapp.interna.core.tree.application.TreeSearch
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/v1/searchByAdoption")
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
                    LocalDate.parse(adoption.adoptionDate).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    adoption.id,
                    godfather.name.uppercase(),
                    godfather.gender.uppercase(),
                    LocalDate.parse(godfather.birthday).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    tree.commonName.uppercase(),
                    tree.species.uppercase(),
                    adoption.district.uppercase(),
                    adoption.neigh.uppercase()
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
