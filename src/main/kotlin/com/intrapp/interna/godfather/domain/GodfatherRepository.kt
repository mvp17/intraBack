package com.intrapp.interna.godfather.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GodfatherRepository: JpaRepository<Godfather, Long>
