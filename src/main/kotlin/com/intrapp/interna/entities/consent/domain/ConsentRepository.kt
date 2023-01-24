package com.intrapp.interna.entities.consent.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ConsentRepository: JpaRepository<Consent, Long> {

    @Query("select c from Consent c where c.representativeId = ?1")
    fun findConsentByRepresentativeId(id: Long): Consent

}
