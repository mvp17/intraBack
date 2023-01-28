package com.intrapp.interna.entities.godfather.domain

import com.intrapp.interna.entities.godfather.domain.interfaces.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SearchByGodfatherRepo:
    JpaRepository<Godfather, Long>,
    SearchByGodfatherNameRepo,
    SearchByGodfatherBirthdayDatesRepo,
    SearchByGodfatherDistrictRepo,
    SearchByGodfatherGenderRepo,
    SearchByGodfatherLastName1Repo,
    SearchByGodfatherLastName2Repo,
    SearchByGodfatherNeighRepo
