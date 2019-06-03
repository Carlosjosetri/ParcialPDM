package com.example.parcial_pdm.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey



@Entity(tableName = "match_table")
data class Match (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "comment") val commit: String,
   // @ForeignKey(entity = Team::class,parentColumns = ["id"],childColumns = ["teams"])
    @ColumnInfo(name = "team1") val team1: String,

    @ColumnInfo(name = "team2") val team2: String

)