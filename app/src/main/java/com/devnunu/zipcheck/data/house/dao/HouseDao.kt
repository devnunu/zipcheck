package com.devnunu.zipcheck.data.house.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.house.entity.HouseEntity

@Dao
interface HouseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHouse(house: HouseEntity)

    @Query("update House set checklist = :checklist where id = :houseId")
    suspend fun updateHouseChecklist(houseId: Int, checklist: Checklist)

    @Query("select * from house")
    fun observeHouseList(): LiveData<List<HouseEntity>>

    @Query("select * from house where id = :houseId")
    fun observeHouse(houseId: Int): LiveData<HouseEntity>

}