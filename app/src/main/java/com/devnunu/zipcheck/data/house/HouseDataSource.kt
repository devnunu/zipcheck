package com.devnunu.zipcheck.data.house

import androidx.lifecycle.LiveData
import com.devnunu.zipcheck.data.house.entity.HouseEntity
import com.devnunu.zipcheck.data.house.model.CheckItem
import com.devnunu.zipcheck.data.house.model.House

interface HouseDataSource {
    fun observeHouseList(): LiveData<List<HouseEntity>>
    fun observeHouse(id: Int): LiveData<HouseEntity>
    suspend fun getHouse(id: Int): HouseEntity
    suspend fun insertHouse(house: House)
    suspend fun deleteHouse(houseId: Int)
    suspend fun updateHouseChecklist(houseId: Int, checklist: List<CheckItem>)
}