package com.devnunu.zipcheck.data.house.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devnunu.zipcheck.data.house.entity.HouseEntity
import com.devnunu.zipcheck.data.house.model.CheckItem

@Dao
interface HouseDao {

    @Query("select * from house")
    fun observeHouseList(): LiveData<List<HouseEntity>>

    @Query("select * from house where id = :houseId")
    fun observeHouse(houseId: Int): LiveData<HouseEntity>

    @Query("select * from house where id = :houseId")
    suspend fun getHouse(houseId: Int): HouseEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHouse(house: HouseEntity)

    @Query("update House set checklist = :checklist where id = :houseId")
    suspend fun updateHouseChecklist(houseId: Int, checklist: List<CheckItem>)

    @Query("delete from House where id = :houseId")
    suspend fun deleteHouse(houseId: Int)

}