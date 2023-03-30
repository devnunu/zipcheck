package com.devnunu.zipcheck.data.db.dao

import androidx.room.*
import com.devnunu.zipcheck.data.model.house.House
import kotlinx.coroutines.flow.Flow

@Dao
interface HouseDao {

    @Query("SELECT * FROM house")
    fun observeAll(): Flow<List<House>>

    @Query("SELECT * FROM house WHERE id = :houseId")
    fun observeById(houseId: Long): Flow<House>

    @Query("SELECT * FROM house")
    fun getAllHouseList(): List<House>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHouse(house: House)

    @Upsert
    suspend fun upsert(house: House)
}