package com.intrapp.interna.entities.tree.application

import com.intrapp.interna.entities.tree.domain.Tree
import com.intrapp.interna.entities.tree.domain.TreeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TreeSearch(private val treeRepository: TreeRepository) {
    fun findTreeById(id: Long): Tree {
        return treeRepository.findById(id)
            .orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Godfather not found!")
            }
    }
}
