package com.devnunu.zipcheck.data.house

import androidx.lifecycle.LiveData
import com.devnunu.zipcheck.data.house.model.House

interface HouseDataSource {
    fun observeHouseList(): LiveData<MutableList<House>>
    fun observeHouse(id: String): LiveData<House?>
    fun getHouse(id: String?): House?
    fun addHouse(house: House)
    fun updateHouse(house: House)
}