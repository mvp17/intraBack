package com.intrapp.interna.entities.consent.application

import com.intrapp.interna.entities.consent.domain.Consent
import com.intrapp.interna.entities.consent.domain.ConsentRepository
import org.springframework.stereotype.Service

@Service
class ConsentSearch(private val consentRepository: ConsentRepository) {

    fun findConsentByRepresentativeId(id: Long): Consent {
        return consentRepository.findConsentByRepresentativeId(id)
    }

}
