package com.intrapp.interna.app.searchByEntity.application

import com.intrapp.interna.entities.godfather.application.*
import org.springframework.stereotype.Service

@Service
class SearchByGodfather(
    val searchGodfatherById: SearchGodfatherById,
    val searchGodfatherByName: SearchGodfatherByName,
    val searchGodfatherByBirthdayDates: SearchGodfatherByBirthdayDates,
    val searchGodfatherByDistrict: SearchGodfatherByDistrict,
    val searchGodfatherByGender: SearchGodfatherByGender,
    val searchGodfatherByLastName1: SearchGodfatherByLastName1,
    val searchGodfatherByLastName2: SearchGodfatherByLastName2,
    val searchGodfatherByNeigh: SearchGodfatherByNeigh
)
