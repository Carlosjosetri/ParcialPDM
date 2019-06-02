package com.example.parcial_pdm.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.parcial_pdm.database.entities.Match
import com.example.parcial_pdm.database.entities.Team


@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertTeam(team: Team)

    @Query("SELECT * FROM team_table")
    fun getAllTeams(): LiveData<List<Team>>

    @Query("SELECT * FROM team_table WHERE id = :id")
    fun getTeam(id: Int): LiveData<List<Team>>


    @Query("SELECT * FROM team_table WHERE name = :name")
    fun getTeams(name: String): LiveData<List<Team>>


}