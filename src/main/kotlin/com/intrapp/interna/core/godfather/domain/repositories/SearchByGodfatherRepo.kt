package com.intrapp.interna.core.godfather.domain.repositories

import com.intrapp.interna.core.godfather.domain.Godfather
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
