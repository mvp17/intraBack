package com.intrapp.interna.entities.tree.domain

import com.intrapp.interna.entities.tree.domain.Tree
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TreeRepository: JpaRepository<Tree, Long>
