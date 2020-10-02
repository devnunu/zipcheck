package com.devnunu.zipcheck.data.house.local

import androidx.lifecycle.LiveData
import com.devnunu.zipcheck.data.house.HouseDataSource
import com.devnunu.zipcheck.data.house.dao.HouseDao
import com.devnunu.zipcheck.data.house.entity.HouseEntity
import com.devnunu.zipcheck.data.house.mapper.toHouseEntity
import com.devnunu.zipcheck.data.house.model.CheckItem
import com.devnunu.zipcheck.data.house.model.House
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalHouseDataSource(
    private val checklistDao: HouseDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HouseDataSource {

    override fun observeHouseList(): LiveData<List<HouseEntity>> {
        return checklistDao.observeHouseList()
    }

    override fun observeHouse(id: Int): LiveData<HouseEntity> {
        return checklistDao.observeHouse(id)
    }

    override suspend fun insertHouse(house: House) = withContext(ioDispatcher) {
        checklistDao.insertHouse(house.toHouseEntity())
    }

    override suspend fun updateHouseChecklist(houseId: Int, checklist: List<CheckItem>) =
        withContext(ioDispatcher) {
            checklistDao.updateHouseChecklist(houseId, checklist)
        }

    override suspend fun deleteHouse(houseId: Int) {
        return checklistDao.deleteHouse(houseId)
    }
}