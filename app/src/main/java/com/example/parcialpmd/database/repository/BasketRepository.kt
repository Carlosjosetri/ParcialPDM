package com.example.parcial_pdm.database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.parcial_pdm.database.daos.MatchDao
import com.example.parcial_pdm.database.daos.ProfileDao
import com.example.parcial_pdm.database.daos.TeamDao
import com.example.parcial_pdm.database.entities.Match
import com.example.parcial_pdm.database.entities.Profile
import com.example.parcial_pdm.database.entities.Team

class BasketRepository(private val profileDao: ProfileDao,private val matchDao: MatchDao,
                       private val teamDao: TeamDao) {

    val allprofiles: LiveData<List<Profile>> = profileDao.getAllProfile()
    val allmatchs: LiveData<List<Match>> = matchDao.getAllMatch()

    val allteams: LiveData<List<Team>> = teamDao.getAllTeams()

    @WorkerThread
    suspend fun insert(profile: Profile) {
        profileDao.InsertProfile(profile)
    }

    @WorkerThread
    suspend fun insert(match: Match) {
        matchDao.InsertMatch(match)
    }

    @WorkerThread
    suspend fun insert(team: Team) {
        teamDao.InsertTeam(team)
    }

    @WorkerThread
    fun FindProfile(IdProfile: Int) {
        profileDao.getProfile(IdProfile)
    }  @WorkerThread
    fun FindMatch(IdMatch: Int) {
        profileDao.getProfile(IdMatch)
    }  @WorkerThread
    fun FindTeam(IdTeam: Int) {
        profileDao.getProfile(IdTeam)
    }


}