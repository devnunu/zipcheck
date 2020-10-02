package com.devnunu.zipcheck.data.house

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.devnunu.zipcheck.data.house.mapper.toHouse
import com.devnunu.zipcheck.data.house.model.CheckItem
import com.devnunu.zipcheck.data.house.model.House
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface HouseRepository {
    fun observeHouseList(): LiveData<List<House>>
    fun observeHouse(id: Int): LiveData<House?>
    suspend fun insertHouse(house: House)
    suspend fun deleteHouse(houseId: Int)
    suspend fun updateHouseChecklist(id: Int, checklist: List<CheckItem>)
}

class DefaultHouseRepository(
    private val localHouseDataSource: HouseDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HouseRepository {

    override fun observeHouseList(): LiveData<List<House>> {
        // null 걸리는 경우 있으니 ? operator 필수 포함
        return localHouseDataSource.observeHouseList()
            .map { houseList -> houseList.map { it?.toHouse() } }
    }

    override fun observeHouse(id: Int): LiveData<House?> {
        // null 걸리는 경우 있으니 ? operator 필수 포함
        return localHouseDataSource.observeHouse(id).map { house -> house?.toHouse() }
    }

    override suspend fun insertHouse(house: House) =
        withContext(ioDispatcher) {
            localHouseDataSource.insertHouse(house)
        }

    override suspend fun updateHouseChecklist(id: Int, checklist: List<CheckItem>) =
        withContext(ioDispatcher) {
            localHouseDataSource.updateHouseChecklist(id, checklist)
        }

    override suspend fun deleteHouse(houseId: Int) {
        return withContext(ioDispatcher) {
            localHouseDataSource.deleteHouse(houseId)
        }
    }
}