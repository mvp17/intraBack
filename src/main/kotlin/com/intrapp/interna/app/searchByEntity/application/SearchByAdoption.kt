package com.intrapp.interna.app.searchByEntity.application

import com.intrapp.interna.entities.adoption.application.*
import org.springframework.stereotype.Service

@Service
class SearchByAdoption(
    val searchAdoptionById: SearchAdoptionById,
    val searchAdoptionByTreeName: SearchAdoptionByTreeName,
    val searchAdoptionByTreeSpecies: SearchAdoptionByTreeSpecies,
    val searchAdoptionByDistrict: SearchAdoptionByDistrict,
    val searchAdoptionByNeigh: SearchAdoptionByNeigh,
    val searchAdoptionByDates: SearchAdoptionByDates,
)
