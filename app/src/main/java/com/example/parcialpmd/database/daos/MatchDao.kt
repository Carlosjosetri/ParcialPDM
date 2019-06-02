package com.example.parcial_pdm.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.parcial_pdm.database.entities.Match
import com.example.parcial_pdm.database.entities.Profile


@Dao
interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertMatch(match: Match)

    @Query("SELECT * FROM match_table")
    fun getAllMatch(): LiveData<List<Match>>

    @Query("SELECT * FROM match_table WHERE id = :id")
    fun getMatch(id: Int): LiveData<List<Match>>





}