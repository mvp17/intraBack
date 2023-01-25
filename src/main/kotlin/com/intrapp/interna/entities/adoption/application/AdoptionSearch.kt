package com.intrapp.interna.entities.adoption.application

import com.intrapp.interna.entities.adoption.domain.Adoption
import com.intrapp.interna.entities.adoption.domain.AdoptionRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AdoptionSearch(private val adoptionRepository: AdoptionRepository) {

    fun findAdoptionsByGodfatherId(id: Long): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByGodfatherId(id)
    }
    fun findAdoptionById(id: Long): Adoption {
        return adoptionRepository.findById(id)
            .orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Adoption not found!")
            }
    }

    // TREE NAME
    // TreeName
    fun findAdoptionsByTreeName(name: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeName(name)
    }
    // TreeName + AdoptionFromDate
    fun findAdoptionsByTreeNameAndAdoptionFromDate(
        treeName: String, fromDate: String
    ): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeNameAndAdoptionFromDate(
            treeName, fromDate
        )
    }
    // TreeName + AdoptionToDate
    fun findAdoptionsByTreeNameAndAdoptionToDate(
        treeName: String, toDate: String
    ): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeNameAndAdoptionToDate(
            treeName, toDate
        )
    }
    // TreeName + AdoptionFromDate + AdoptionToDate
    fun findAdoptionsByTreeNameAndAdoptionFromDateAndAdoptionToDate(
        treeName: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeNameAndAdoptionFromDateAndAdoptionToDate(
            treeName, fromDate, toDate
        )
    }

    // TREE SPECIES
    // TreeSpecies
    fun findAdoptionsByTreeSpecies(treeSpecies: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeSpecies(treeSpecies)
    }
    // TreeSpecies + AdoptionFromDate
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDate(
        treeSpecies: String, fromDate: String
    ): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeSpeciesAndAdoptionFromDate(treeSpecies, fromDate)
    }
    // TreeSpecies + AdoptionToDate
    fun findAdoptionsByTreeSpeciesAndAdoptionToDate(
        treeSpecies: String, toDate: String
    ): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeSpeciesAndAdoptionToDate(treeSpecies, toDate)
    }
    // TreeSpecies + AdoptionFromDate + AdoptionToDate
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
        treeSpecies: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
            treeSpecies, fromDate, toDate
        )
    }

    // DISTRICT
    fun findAdoptionsByDistrict(district: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByDistrict(district)
    }

    fun findAdoptionsByDistrictAndAdoptionFromDate(district: String, fromDate: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByDistrictAndAdoptionFromDate(district, fromDate)
    }
    fun findAdoptionsByDistrictAndAdoptionToDate(district: String, toDate: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByDistrictAndAdoptionToDate(district, toDate)
    }
    fun findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
        district: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
            district, fromDate, toDate)
    }
    fun findAdoptionsByNeigh(neigh: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByNeigh(neigh)
    }

    fun findAdoptionsByNeighAndAdoptionFromDate(neigh: String, fromDate: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByNeighAndAdoptionFromDate(neigh, fromDate)
    }

    fun findAdoptionsByNeighAndAdoptionToDate(neigh: String, toDate: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByNeighAndAdoptionToDate(neigh, toDate)
    }

    fun findAdoptionsByNeighAndAdoptionFromDateAndAdoptionToDate(
        neigh: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByNeighAndAdoptionFromDateAndAdoptionToDate(neigh, fromDate, toDate)
    }

    fun findAdoptionsByAdoptionFromDate(date: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByFromDate(date)
    }
    fun findAdoptionsByAdoptionToDate(date: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByToDate(date)
    }
    fun findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate: String, toDate: String): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate, toDate)
    }
}
