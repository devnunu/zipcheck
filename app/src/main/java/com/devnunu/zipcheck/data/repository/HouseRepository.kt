package com.devnunu.zipcheck.data.repository

import com.devnunu.zipcheck.api.HouseApi
import com.devnunu.zipcheck.data.model.common.ResResult
import com.devnunu.zipcheck.data.model.common.wrapAsResResult
import com.devnunu.zipcheck.data.model.house.House
import com.devnunu.zipcheck.data.model.house.HouseWriteStatus
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await

class HouseRepository(
    private val houseApi: HouseApi
) {

    private val _houseListFlow = MutableStateFlow<List<House>>(mutableListOf())

    /**
     * Observer
     * */
    fun getHouseListFlow(): StateFlow<List<House>> = _houseListFlow

    /**
     * CRUD
     * */
    suspend fun getAllHouseList(): ResResult<List<House>> = wrapAsResResult {
        val houseList = houseApi.getAllHouseList()
        _houseListFlow.value = houseList
        houseList
    }


    suspend fun addHouse(house: House) = wrapAsResResult {
        val house = houseApi.addHouse(house)
        val houseList = _houseListFlow.value.toMutableList()
        houseList.add(house)
        _houseListFlow.value = houseList
    }

    suspend fun updateHouse(house: House) = wrapAsResResult {
        val newHouse = houseApi.updateHouse(house)
        val houseList = _houseListFlow.value.toMutableList().map { house ->
            if (house.id == newHouse.id) newHouse else house
        }
        _houseListFlow.value = houseList
    }
}