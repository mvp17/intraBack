package com.intrapp.interna.tree.domain

import com.intrapp.interna.tree.domain.Tree
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TreeRepository: JpaRepository<Tree, Long> {
    @Query("select t from Tree t where t.id = ?1")
    fun findTreeByAdoptionTreeID(id: Long): Tree
}
