package com.devnunu.zipcheck.data.repository

import com.devnunu.zipcheck.data.model.House
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HouseRepository {

    private val _houseListFlow = MutableStateFlow<List<House>>(mutableListOf())

//    init {
//        val houseList = mutableListOf<House>()
//        repeat(20) {
//            houseList.add(House())
//        }
//        _houseListFlow.value = houseList
//    }

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
}