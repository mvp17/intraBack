package com.intrapp.interna.core.adoption.domain.repositories

import com.intrapp.interna.core.adoption.domain.Adoption
import com.intrapp.interna.core.adoption.domain.repositories.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SearchByAdoptionRepo:
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
