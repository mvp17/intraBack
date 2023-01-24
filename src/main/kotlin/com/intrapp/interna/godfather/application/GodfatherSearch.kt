package com.intrapp.interna.godfather.application

import com.intrapp.interna.godfather.domain.Godfather
import com.intrapp.interna.godfather.domain.GodfatherRepository
import org.springframework.stereotype.Service

@Service
class GodfatherSearch(private val godfatherRepository: GodfatherRepository) {
    fun searchByGodfatherName(name: String): MutableList<Godfather> {
        return godfatherRepository.findGodfatherByName(name)
    }
}
