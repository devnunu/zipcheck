package com.devnunu.zipcheck.data.repository

import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.model.HouseWriteStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HouseRepository {

    private val _houseListFlow = MutableStateFlow<List<House>>(mutableListOf())

    init {
        val houseList = mutableListOf<House>()
        repeat(5) {
            houseList.add(House())
        }
        _houseListFlow.value = houseList
    }

    /**
     * Observer
     * */
    fun getHouseListFlow(): StateFlow<List<House>> = _houseListFlow

    /**
     * CRUD
     * */
    fun addHouse(house: House) {
        val houseList = _houseListFlow.value.toMutableList()
        houseList.add(house)
        _houseListFlow.value = houseList
    }

    fun updateHouse(newHouse: House) {
        val houseList = _houseListFlow.value.toMutableList().map { house ->
            if (house.id == newHouse.id) newHouse else house
        }
        _houseListFlow.value = houseList
    }
}