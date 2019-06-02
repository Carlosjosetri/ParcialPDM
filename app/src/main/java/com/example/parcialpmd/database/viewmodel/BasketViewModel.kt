package com.example.parcial_pdm.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_pdm.database.BasketRoomDatabase
import com.example.parcial_pdm.database.entities.Match
import com.example.parcial_pdm.database.entities.Profile
import com.example.parcial_pdm.database.entities.Team
import com.example.parcial_pdm.database.repository.BasketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BasketViewModel (app: Application): AndroidViewModel(app){

   private val basketRepository : BasketRepository

    init {
        val profiledao=BasketRoomDatabase.getInstance(app).profileDao()
        val matchdao=BasketRoomDatabase.getInstance(app).matchDao()
        val teamdao=BasketRoomDatabase.getInstance(app).teamDao()
        basketRepository=BasketRepository(profiledao,matchdao,teamdao)
    }

    fun getAllProfile(): LiveData<List<Profile>> {
        return basketRepository.allprofiles

    }  fun getAllMatchs(): LiveData<List<Match>> {
        return basketRepository.allmatchs

    }  fun getAllTeams(): LiveData<List<Team>> {
        return basketRepository.allteams

    }
fun insert(profile: Profile) = viewModelScope.launch(Dispatchers.IO){
    basketRepository.insert(profile)
}fun insert(match: Match) = viewModelScope.launch(Dispatchers.IO){
    basketRepository.insert(match)
}fun insert(team: Team) = viewModelScope.launch(Dispatchers.IO){
    basketRepository.insert(team)
}

    fun getProfile(idprofile: Int) {
        return basketRepository.FindProfile(idprofile)
    }fun getMatch(idMatch: Int) {
        return basketRepository.FindProfile(idMatch)
    }fun getTeam(idTeam: Int) {
        return basketRepository.FindProfile(idTeam)
    }

}
