package com.devnunu.zipcheck.data.house.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devnunu.zipcheck.data.house.model.House

class HouseRepository {

    private var inputHouse: House? = null

    private val houseList = MutableLiveData<List<House>>()

    fun observeHouseList(): LiveData<List<House>> {
        return houseList
    }


    /** 사용자 입력으로 새로 추가되는 house */
    fun getInputHouse(): House? {
        return inputHouse
    }

    fun setInputHouse(house: House?) {
        inputHouse = house
    }
}