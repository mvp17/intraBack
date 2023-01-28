package com.intrapp.interna.entities.adoption.domain

import com.intrapp.interna.entities.adoption.domain.interfaces.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SearchByAdoptionAdoptionAdoptionAdoptionRepo:
    JpaRepository<Adoption, Long>,
    SearchByAdoptionDatesRepo,
    SearchByAdoptionDistrictRepo,
    SearchByAdoptionNeighRepo,
    SearchByTreeNameRepo,
    SearchByTreeSpeciesRepo
{
    @Query("select a from Adoption a where a.godfatherId = ?1")
    fun findAdoptionsByGodfatherId(id: Long): MutableList<Adoption>
}
