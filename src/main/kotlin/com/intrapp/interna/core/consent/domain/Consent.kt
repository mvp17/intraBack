package com.intrapp.interna.core.consent.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@Table(name = "consent")
data class Consent(
    @Column(name = "dato_consentimiento_padron")
    var censusConsent: Boolean,

    @Column(name = "fecha_consentimiento_padron")
    var censusConsentDate: String,

    @Column(name = "autorizacion_mayor_edad")
    var adultAuthorization: Boolean,

    @Column(name = "fecha_consentimiento_autorizacion_mayor_edad")
    val adultAuthorizationConsentDate: String,

    @Column(name = "tutor_legal")
    val guardian: Boolean,

    @Column(name = "fecha_consentimiento_tutor_legal")
    val guardianConsentDate: String,

    @Column(name = "visible_otros")
    val visibleOthers: Boolean,

    @Column(name = "fecha_consentimiento_visible_otros")
    val visibleOthersConsentDate: String,

    @Column(name = "comentario")
    val comment: String,

    @Column(name = "representante")
    val representativeId: Long,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
