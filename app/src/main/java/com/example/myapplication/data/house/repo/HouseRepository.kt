package com.example.myapplication.data.house.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.house.model.House

class HouseRepository {

    private val houseList = MutableLiveData<List<House>>()

    fun observeHouseList(): LiveData<List<House>> {
        return houseList
    }
}