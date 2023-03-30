package com.devnunu.zipcheck.data.repository

import com.devnunu.zipcheck.data.db.dao.HouseDao
import com.devnunu.zipcheck.data.model.common.wrapAsResResult
import com.devnunu.zipcheck.data.model.house.House
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HouseRepository(
    private val localDataSource: HouseDao,
) {

    /**
     * Observer
     * */
    suspend fun getHouseListFlow(): StateFlow<List<House>> {
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        return localDataSource.observeAll().stateIn(coroutineScope)
    }


    /**
     * CRUD
     * */
    suspend fun addHouse(house: House) = wrapAsResResult {
        localDataSource.addHouse(house)
    }

    suspend fun updateHouse(house: House) = wrapAsResResult {
        localDataSource.upsert(house)
    }
}