package com.intrapp.interna.adoptions.domain.repositories

import com.intrapp.interna.adoptions.domain.entities.Adoption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRepository: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a where a.godfatherId = ?1")
    fun findAdoptionsFromGodfather(id: Long): MutableList<Adoption>
}
