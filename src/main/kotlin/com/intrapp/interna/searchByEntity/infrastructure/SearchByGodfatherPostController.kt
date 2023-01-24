package com.intrapp.interna.searchByEntity.infrastructure

import com.intrapp.interna.adoption.application.AdoptionSearch
import com.intrapp.interna.searchByEntity.domain.FilterJSONGodfatherDTO
import com.intrapp.interna.searchByEntity.domain.ResponseDTO
import com.intrapp.interna.searchByEntity.domain.TableDataResultsDTO
import com.intrapp.interna.godfather.application.GodfatherSearch
import com.intrapp.interna.tree.application.TreeSearch
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
    fun getAllAdoptionsByGodfather(@RequestBody filter: FilterJSONGodfatherDTO):
            ResponseDTO {
        val tableDataResultsList: MutableList<TableDataResultsDTO> = mutableListOf()

        val godfathers = godfatherService.searchByGodfatherName(filter.name)
        for (godfather in godfathers) {
            val adoptions = adoptionService.getAllAdoptionsFromGodfather(godfather.id)
            for (adoption in adoptions) {
                val tree = treeService.getTreeFromAdoptionTreeID(adoption.treeId)
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
