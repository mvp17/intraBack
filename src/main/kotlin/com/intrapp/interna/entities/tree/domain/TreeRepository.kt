package com.intrapp.interna.entities.tree.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TreeRepository: JpaRepository<Tree, Long>
