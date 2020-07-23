package com.example.myapplication.data

import androidx.room.*

@Dao
interface HousesDao {
    @Query("SELECT * FROM Houses")
    suspend fun getHouses(): List<House>

    @Query("SELECT * FROM Houses WHERE houseId = :houseId")
    suspend fun getHouseById(houseId: String): House?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHouse(house: House)

    @Update
    suspend fun updateHouse(house: House): Int
}