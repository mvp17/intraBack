package com.intrapp.interna.entities.adoption.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRepository: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a where a.godfatherId = ?1")
    fun findAdoptionsByGodfatherId(id: Long): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.commonName like %?1%")
    fun findAdoptionsByTreeName(name: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and " +
            "t.commonName like %?1% and a.adoptionDate >= date(?2)")
    fun findAdoptionsByTreeNameAndAdoptionFromDate(name: String, date: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.commonName like %?1% " +
            "and a.adoptionDate <= date(?2)")
    fun findAdoptionsByTreeNameAndAdoptionToDate(name: String, date: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.commonName like %?1% " +
            "and a.adoptionDate >= date(?2) and a.adoptionDate <= date(?3)")
    fun findAdoptionsByTreeNameAndAdoptionFromDateAndAdoptionToDate(
        name: String, fromDate: String, toDate: String
    ): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.species like %?1%")
    fun findAdoptionsByTreeSpecies(species: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.species like %?1% " +
            "and a.adoptionDate >= date(?2)")
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDate(species: String, date: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.species like %?1% " +
            "and a.adoptionDate <= date(?2)")
    fun findAdoptionsByTreeSpeciesAndAdoptionToDate(species: String, date: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.species like %?1% " +
            "and a.adoptionDate >= date(?2) and a.adoptionDate <= date(?3)")
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
        species: String, fromDate: String, toDate: String
    ): MutableList<Adoption>

    @Query("select a from Adoption a where a.adoptionDate >= date(?1)")
    fun findAdoptionsByFromDate(date: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.adoptionDate <= date(?1)")
    fun findAdoptionsByToDate(date: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.adoptionDate >= date(?1) and a.adoptionDate <= date(?2)")
    fun findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate: String, toDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.district like %?1%")
    fun findAdoptionsByDistrict(district: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.district like %?1% and a.adoptionDate >= date(?2)")
    fun findAdoptionsByDistrictAndAdoptionFromDate(district: String, fromDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.district like %?1% and a.adoptionDate <= date(?2)")
    fun findAdoptionsByDistrictAndAdoptionToDate(district: String, toDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.district like %?1% and a.adoptionDate >= date(?2) " +
            "and a.adoptionDate <= date(?3)")
    fun findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
        district: String, fromDate: String, toDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.neigh like %?1%")
    fun findAdoptionsByNeigh(neigh: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.neigh like %?1% and a.adoptionDate >= date(?2)")
    fun findAdoptionsByNeighAndAdoptionFromDate(neigh: String, fromDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.neigh like %?1% and a.adoptionDate <= date(?2)")
    fun findAdoptionsByNeighAndAdoptionToDate(neigh: String, toDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.neigh like %?1% and a.adoptionDate >= date(?2) " +
            "and a.adoptionDate <= date(?3)")
    fun findAdoptionsByNeighAndAdoptionFromDateAndAdoptionToDate(
        neigh: String, fromDate: String, toDate: String): MutableList<Adoption>
}
