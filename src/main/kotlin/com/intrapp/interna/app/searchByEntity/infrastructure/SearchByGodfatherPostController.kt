package com.intrapp.interna.app.searchByEntity.infrastructure

import com.intrapp.interna.entities.adoption.application.AdoptionSearch
import com.intrapp.interna.app.searchByEntity.domain.FilterJSONGodfatherDTO
import com.intrapp.interna.app.searchByEntity.domain.ResponseDTO
import com.intrapp.interna.app.searchByEntity.domain.TableDataResultsDTO
import com.intrapp.interna.entities.godfather.application.GodfatherSearch
import com.intrapp.interna.entities.tree.application.TreeSearch
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/searchByGodfather"])
class SearchByGodfatherPostController(
    private val godfatherService: GodfatherSearch,
    private val adoptionService: AdoptionSearch,
    private  val treeService: TreeSearch
    ) {
    @PostMapping
    fun getAllAdoptionsByGodfather(@RequestBody filter: FilterJSONGodfatherDTO): ResponseDTO {
        val tableDataResultsList: MutableList<TableDataResultsDTO> = mutableListOf()
        val godfathers = godfatherService.searchByGodfatherName(filter.name)
        for (godfather in godfathers) {
            val adoptions = adoptionService.findAdoptionsByGodfatherId(godfather.id)
            for (adoption in adoptions) {
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
        }
        val totalRecords: Int = tableDataResultsList.size
        return ResponseDTO(tableDataResultsList, totalRecords)
    }
}
