package com.intrapp.interna.searchByEntity.domain

data class ResponseDTO(
    val tableDataResultsList: MutableList<TableDataResultsDTO>,
    val totalRecords: Int
)
