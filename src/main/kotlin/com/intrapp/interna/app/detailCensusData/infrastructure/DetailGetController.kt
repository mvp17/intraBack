package com.intrapp.interna.app.detailCensusData.infrastructure

import com.intrapp.interna.entities.adoption.application.SearchAdoptionById
import com.intrapp.interna.entities.consent.application.ConsentSearch
import com.intrapp.interna.app.detailCensusData.domain.ResponseDTO
import com.intrapp.interna.app.searchByEntity.application.SearchByGodfather
import com.intrapp.interna.entities.bdcLocation.application.BDCLocationSearch
import com.intrapp.interna.entities.padronAddress.application.CensusAddressSearch
import com.intrapp.interna.entities.representative.application.RepresentativeSearch
import com.intrapp.interna.entities.tree.application.TreeSearch
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/detailCensus/adoption"])
class DetailGetController(
    private val searchByGodfather: SearchByGodfather,
    private val searchAdoptionById: SearchAdoptionById,
    private val representativeSearch: RepresentativeSearch,
    private val treeSearch: TreeSearch,
    private val consentSearch: ConsentSearch,
    private val censusAddressSearch: CensusAddressSearch,
    private val bdcLocationSearch: BDCLocationSearch
    ) {
    @GetMapping("/{id}")
    fun getDetailCensusDataForAdoptionByAdoptionId(@PathVariable id: Long): ResponseDTO {
        val adoption = searchAdoptionById.findAdoptionById(id)
        val godfather = searchByGodfather.searchGodfatherById.findGodfatherById(adoption.godfatherId)
        val representative = representativeSearch.findRepresentativeById(adoption.representativeId)
        val tree = treeSearch.findTreeById(adoption.treeId)
        val consent = consentSearch.findConsentByRepresentativeId(adoption.representativeId)
        val censusAddress = censusAddressSearch.findCensusAddressByRepresentativeId(adoption.representativeId)
        val bdcLocation = bdcLocationSearch.findBDCLocationByRepresentativeId(adoption.representativeId)
        return ResponseDTO(godfather, representative, adoption, tree, consent, censusAddress, bdcLocation)
    }
}