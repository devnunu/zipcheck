package com.devnunu.zipcheck.data.house.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devnunu.zipcheck.data.house.model.House

class HouseRepository {

    private val houseList = MutableLiveData<List<House>>()

    fun observeHouseList(): LiveData<List<House>> {
        return houseList
    }
}