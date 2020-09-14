package com.devnunu.zipcheck.data.house.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.devnunu.zipcheck.data.house.model.House

class HouseRepository {

    private var inputHouse: House? = null

    private val houseList = MutableLiveData<MutableList<House>>()

    fun observeHouseList(): LiveData<MutableList<House>> {
        return houseList
    }

    fun observeHouse(id: String): LiveData<House?> {
        return houseList.map {
            it.firstOrNull { house ->
                house.id == id
            }
        }
    }

    /** 사용자 입력으로 새로 추가되는 house */
    fun getInputHouse(id: String?): House? {
        return houseList.value?.firstOrNull {
            it.id == id
        }
    }

    fun getInputHouse(): House? {
        return inputHouse
    }

    fun setInputHouse(house: House?) {
        inputHouse = house
    }

    /** house list CRUD */
    fun addHouse(house: House) {
        val list = houseList.value ?: mutableListOf()
        list.add(house)
        houseList.value = list
    }

    fun updateHouse(house: House) {
        val list = houseList.value ?: mutableListOf()
        list.map {
            if (it.id == house.id) house else it
        }
        houseList.value = list
    }
}