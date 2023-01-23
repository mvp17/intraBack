package com.intrapp.interna.adoptions.domain.dtos

data class SearchByEntityResponse(
    val tableDataResultsList: MutableList<TableDataResults>,
    val totalRecords: Int
)
