package com.intrapp.interna.app.searchByEntity.infrastructure

import com.intrapp.interna.entities.adoption.application.AdoptionSearch
import com.intrapp.interna.entities.godfather.application.GodfatherSearch
import com.intrapp.interna.app.searchByEntity.domain.FilterJSONAdoptionDTO
import com.intrapp.interna.app.searchByEntity.domain.ResponseDTO
import com.intrapp.interna.app.searchByEntity.domain.TableDataResultsDTO
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
    private  val treeService: TreeSearch
    ) {

    @PostMapping
    fun getAllAdoptionsByAdoption(@RequestBody filter: FilterJSONAdoptionDTO):
            ResponseDTO {
        val tableDataResultsList: MutableList<TableDataResultsDTO> = mutableListOf()

        val adoptions = adoptionService.findAdoptionsByTreeName(filter.treeName)
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
        val totalRecords: Int = tableDataResultsList.size
        return ResponseDTO(tableDataResultsList, totalRecords)
    }
}
