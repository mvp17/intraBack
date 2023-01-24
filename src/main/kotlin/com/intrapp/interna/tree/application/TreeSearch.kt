package com.intrapp.interna.tree.application

import com.intrapp.interna.tree.domain.Tree
import com.intrapp.interna.tree.domain.TreeRepository
import org.springframework.stereotype.Service

@Service
class TreeSearch(private val treeRepository: TreeRepository) {
    fun getTreeFromAdoptionTreeID(id: Long): Tree {
        return treeRepository.findTreeByAdoptionTreeID(id)
    }
}
