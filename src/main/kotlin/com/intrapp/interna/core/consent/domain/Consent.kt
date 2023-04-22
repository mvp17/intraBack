package com.intrapp.interna.core.consent.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@Table(name = "consents")
data class Consent(
    @Column(name = "census_consent")
    var censusConsent: Boolean,

    @Column(name = "census_consent_date")
    var censusConsentDate: String,

    @Column(name = "adult_authorization")
    var adultAuthorization: Boolean,

    @Column(name = "adult_authorization_date")
    val adultAuthorizationConsentDate: String,

    @Column(name = "guardian")
    val guardian: Boolean,

    @Column(name = "guardian_date")
    val guardianConsentDate: String,

    @Column(name = "visible_others")
    val visibleOthers: Boolean,

    @Column(name = "visible_others_date")
    val visibleOthersConsentDate: String,

    @Column(name = "comment")
    val comment: String,

    @Column(name = "representative_id")
    val representativeId: Long,

    @Column(name = "godfather_id")
    val godfatherId: Long,

    @Column(name = "adoption_id")
    val adoptionId: Long,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
