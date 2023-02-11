package com.intrapp.interna.app.detailCensusData.infrastructure

import com.intrapp.interna.app.detailCensusData.domain.*
import com.intrapp.interna.entities.adoption.application.SearchAdoptionById
import com.intrapp.interna.entities.consent.application.ConsentSearch
import com.intrapp.interna.app.searchByEntity.application.SearchByGodfather
import com.intrapp.interna.entities.bdcLocation.application.BDCLocationSearch
import com.intrapp.interna.entities.censusAddress.application.CensusAddressSearch
import com.intrapp.interna.entities.representative.application.RepresentativeSearch
import com.intrapp.interna.entities.tree.application.TreeSearch
import org.springframework.web.bind.annotation.*

@RestController
//@CrossOrigin(origins = ["http://localhost:4200"])
@RequestMapping("/api/v1/detailCensus/adoption")
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
        // LocalDate.parse(adoption.adoptionDate).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
        val adoptionDTO = AdoptionDTO(adoption.id, adoption.adoptionDate)
        val godfather = searchByGodfather.searchGodfatherById.findGodfatherById(adoption.godfatherId)
        val representative = representativeSearch.findRepresentativeById(adoption.representativeId)
        val tree = treeSearch.findTreeById(adoption.treeId)
        val treeDTO = TreeDTO(
            tree.id,
            tree.treePositionId,
            tree.xCoord,
            tree.yCoord,
            tree.commonName,
            tree.species,
            adoption.district,
            adoption.neigh,
            tree.godfatherDistance
        )
        val consent = consentSearch.findConsentByRepresentativeId(adoption.representativeId)
        val censusAddress = censusAddressSearch.findCensusAddressByRepresentativeId(adoption.representativeId)
        val censusAddressDTO = CensusAddressDTO(
            censusAddress.streetType,
            censusAddress.streetName,
            censusAddress.streetNumber,
            censusAddress.staircase,
            censusAddress.floor,
            censusAddress.door,
            censusAddress.zipCode
        )
        val bdcLocation = bdcLocationSearch.findBDCLocationByRepresentativeId(adoption.representativeId)
        val bdcLocationDTO = BDCLocationDTO(
            bdcLocation.streetType,
            bdcLocation.streetName,
            bdcLocation.streetName,
            bdcLocation.staircase,
            bdcLocation.floor,
            bdcLocation.door,
            bdcLocation.zipCode,
            bdcLocation.ndpBDCClass,
            bdcLocation.ndp,
            bdcLocation.xCoord,
            bdcLocation.yCoord,
            bdcLocation.district,
            bdcLocation.neigh
        )
        return ResponseDTO(godfather, representative, adoptionDTO, treeDTO, consent, censusAddressDTO, bdcLocationDTO)
    }
}