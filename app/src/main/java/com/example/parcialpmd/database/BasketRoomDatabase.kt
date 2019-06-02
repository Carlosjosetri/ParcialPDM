package com.example.parcial_pdm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial_pdm.database.daos.MatchDao
import com.example.parcial_pdm.database.daos.ProfileDao
import com.example.parcial_pdm.database.daos.TeamDao
import com.example.parcial_pdm.database.entities.Match
import com.example.parcial_pdm.database.entities.Profile
import com.example.parcial_pdm.database.entities.Team

@Database(entities = [Profile::class, Team::class, Match::class ], version = 1, exportSchema = false)
public abstract class BasketRoomDatabase : RoomDatabase() {

    abstract fun profileDao():ProfileDao
    abstract fun matchDao(): MatchDao
    abstract fun teamDao(): TeamDao

    companion object {

        @Volatile
        private var INSTANCE: BasketRoomDatabase? = null


        fun getInstance(
            context: Context
        ): BasketRoomDatabase {

            val temp = INSTANCE

            if (temp != null) return temp
            else synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context,
                            BasketRoomDatabase::class.java,
                            "Basket_Database"
                        )
                        .build()

                INSTANCE = instance

                return instance
            }

        }


    }
}