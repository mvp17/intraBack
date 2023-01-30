package com.intrapp.interna.app.searchByEntity.infrastructure

import com.intrapp.interna.app.searchByEntity.application.utils.GodfatherFilterUtils
import com.intrapp.interna.app.searchByEntity.application.SearchByAdoption
import com.intrapp.interna.app.searchByEntity.application.SearchByGodfather
import com.intrapp.interna.app.searchByEntity.domain.FilterJSONGodfatherDTO
import com.intrapp.interna.app.searchByEntity.domain.ResponseDTO
import com.intrapp.interna.app.searchByEntity.domain.TableDataResultsDTO
import com.intrapp.interna.entities.godfather.domain.Godfather
import com.intrapp.interna.entities.tree.application.TreeSearch
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/searchByGodfather"])
class SearchByGodfatherPostController(
    private val searchByAdoption: SearchByAdoption,
    private val searchByGodfather: SearchByGodfather,
    private val godfatherFilterUtils: GodfatherFilterUtils,
    private  val treeService: TreeSearch
    ) {
    @PostMapping
    fun getAllAdoptionsByGodfather(@RequestBody filter: FilterJSONGodfatherDTO): ResponseDTO {
        val tableDataResultsList: MutableList<TableDataResultsDTO> = mutableListOf()
        val godfathers = getGodfathersByFilter(filter)
        for (godfather in godfathers) {
            val adoptions = searchByAdoption.searchAdoptionById.findAdoptionsByGodfatherId(godfather.id)
            for (adoption in adoptions) {
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
        }
        val totalRecords: Int = tableDataResultsList.size
        return ResponseDTO(tableDataResultsList, totalRecords)
    }

    fun getGodfathersByFilter(filter: FilterJSONGodfatherDTO): List<Godfather> {
        val godfathers: MutableList<Godfather> = mutableListOf()

        if (filter.hasGodfatherId()) {
            godfathers.add(searchByGodfather.searchGodfatherById.findGodfatherById(filter.godfatherId!!.toLong()))
            return godfathers
        }

        if (!filter.hasGodfatherBirthdayFromDate() and !filter.hasGodfatherBirthdayToDate())
            return godfatherFilterUtils.filterWhenNoDates(filter, godfathers)
        else if (
            filter.hasGodfatherName()       or
            filter.hasGodfatherLastName1()  or
            filter.hasGodfatherLastName2()  or
            filter.hasGodfatherGender()     or
            filter.hasGodfatherDistrict()   or
            filter.hasGodfatherNeigh()
        ) {
            godfatherFilterUtils.filterWhenNameAndDates(filter, godfathers)
            godfatherFilterUtils.filterWhenLastName1AndDates(filter, godfathers)
            godfatherFilterUtils.filterWhenLastName2AndDates(filter, godfathers)
            godfatherFilterUtils.filterWhenGenderAndDates(filter, godfathers)
            godfatherFilterUtils.filterWhenDistrictAndDates(filter, godfathers)
            godfatherFilterUtils.filterWhenNeighAndDates(filter, godfathers)
            return godfathers.distinct()
        }
        else return godfatherFilterUtils.filterWhenOnlyDates(filter, godfathers)
    }
}
