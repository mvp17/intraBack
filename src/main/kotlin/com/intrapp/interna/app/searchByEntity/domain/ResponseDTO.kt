package com.intrapp.interna.app.searchByEntity.domain

data class ResponseDTO(
    val tableDataResultsList: MutableList<TableDataResultsDTO>,
    val totalRecords: Int
)
