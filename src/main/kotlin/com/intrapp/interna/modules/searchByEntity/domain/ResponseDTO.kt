package com.intrapp.interna.modules.searchByEntity.domain

data class ResponseDTO(
    val tableDataResultsList: MutableList<TableDataResultsDTO>,
    val totalRecords: Int
)
