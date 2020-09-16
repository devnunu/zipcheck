package com.devnunu.zipcheck.data.house.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.devnunu.zipcheck.data.house.HouseDataSource
import com.devnunu.zipcheck.data.house.model.House

class LocalHouseDataSource : HouseDataSource {

    private val houseList = MutableLiveData<MutableList<House>>()

    override fun observeHouseList(): LiveData<MutableList<House>> {
        return houseList
    }

    override fun observeHouse(id: String): LiveData<House?> {
        return houseList.map {
            it.firstOrNull { house ->
                house.id == id
            }
        }
    }

    override fun getHouse(id: String?): House? {
        return houseList.value?.firstOrNull {
            it.id == id
        }
    }

    override fun addHouse(house: House) {
        val list = houseList.value ?: mutableListOf()
        list.add(house)
        houseList.value = list
    }

    override fun updateHouse(house: House) {
        val list = houseList.value ?: mutableListOf()
        list.map {
            if (it.id == house.id) house else it
        }
        houseList.value = list
    }
}