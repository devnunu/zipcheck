package com.devnunu.zipcheck.data.repository

import com.devnunu.zipcheck.data.model.house.House
import com.devnunu.zipcheck.data.model.house.HouseWriteStatus
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await

class HouseRepository(
    private val fireStore: FirebaseFirestore
) {

    private val _houseListFlow = MutableStateFlow<List<House>>(mutableListOf())

    /**
     * Observer
     * */
    fun getHouseListFlow(): StateFlow<List<House>> = _houseListFlow

    /**
     * CRUD
     * */
    suspend fun getAllHouseList(): List<House> {
        val houseList: List<House> = fireStore.collection(COLLECTION_HOUSES)
            .get()
            .await()
            .map { it.toObject() }
        _houseListFlow.value = houseList
        return houseList
    }


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

    companion object {
        const val COLLECTION_HOUSES = "houses"
    }
}