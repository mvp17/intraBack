package com.intrapp.interna.core.consent.application

import com.intrapp.interna.core.consent.domain.Consent
import com.intrapp.interna.core.consent.domain.ConsentRepository
import org.springframework.stereotype.Service

@Service
class ConsentSearch(private val consentRepository: ConsentRepository) {

    fun findConsentByRepresentativeId(id: Long): Consent {
        return consentRepository.findConsentByRepresentativeId(id)
    }

}
