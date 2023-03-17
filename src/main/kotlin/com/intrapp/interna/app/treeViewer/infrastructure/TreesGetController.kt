package com.intrapp.interna.app.treeViewer.infrastructure

import com.intrapp.interna.entities.tree.application.TreeSearch
import com.intrapp.interna.entities.tree.domain.Tree
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/treeViewer")
class TreesGetController(private val treeSearch: TreeSearch) {

    @GetMapping("/trees")
    fun getAllTrees(): List<Tree> {
        return treeSearch.findTrees().sortedBy { tree: Tree -> tree.id }
    }
}