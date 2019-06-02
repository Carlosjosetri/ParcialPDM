package com.example.parcial_pdm.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "profile_table")
data class Profile (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "password") val password: String,
    @ForeignKey(entity = Match::class,parentColumns = ["id"],childColumns = ["match_id"])
    @ColumnInfo(name = "match_id") val match_id: Int

)