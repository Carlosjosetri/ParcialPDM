package com.example.parcial_pdm.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "team_table")
data class Team(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "points")val points: Int,
    @ColumnInfo(name = "victory") val vicotry: Int

    )