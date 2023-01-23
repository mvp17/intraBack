package com.intrapp.interna.adoptions.application

import com.intrapp.interna.adoptions.domain.entities.Adoption
import com.intrapp.interna.adoptions.domain.entities.Godfather
import com.intrapp.interna.adoptions.domain.entities.Tree
import com.intrapp.interna.adoptions.domain.repositories.AdoptionRepository
import com.intrapp.interna.adoptions.domain.repositories.GodfatherRepository
import com.intrapp.interna.adoptions.domain.repositories.TreeRepository
import org.springframework.stereotype.Service

@Service
class SearchByGodfatherService(private val godfatherRepository: GodfatherRepository,
                               private val adoptionRepository: AdoptionRepository,
                               private val treeRepository: TreeRepository) {

    fun searchByGodfatherName(name: String): MutableList<Godfather> {
        return godfatherRepository.findGodfatherByName(name)
    }

    fun getAllAdoptionsFromGodfather(id: Long): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsFromGodfather(id)
    }

    fun getTreeFromAdoptionTreeID(id: Long): Tree {
        return treeRepository.findTreeByAdoptionTreeID(id)
    }
}
