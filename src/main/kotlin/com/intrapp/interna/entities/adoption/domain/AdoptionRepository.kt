package com.intrapp.interna.entities.adoption.domain

import com.intrapp.interna.entities.adoption.domain.Adoption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRepository: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a where a.godfatherId = ?1")
    fun findAdoptionsByGodfatherId(id: Long): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.commonName = ?1")
    fun findAdoptionsByTreeName(name: String): MutableList<Adoption>
}
