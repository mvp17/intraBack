package com.intrapp.interna.godfather.domain

import com.intrapp.interna.godfather.domain.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface GodfatherRepository: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.name = ?1")
    fun findGodfatherByName(name: String): MutableList<Godfather>
}
