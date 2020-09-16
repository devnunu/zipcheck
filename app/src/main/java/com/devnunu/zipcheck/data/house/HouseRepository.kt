package com.devnunu.zipcheck.data.house

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.devnunu.zipcheck.data.house.model.House

interface HouseRepository {
    fun observeHouseList(): LiveData<MutableList<House>>
    fun observeHouse(id: String): LiveData<House?>
    fun getHouse(id: String?): House?
    fun addHouse(house: House)
    fun updateHouse(house: House)
}

class DefaultHouseRepository(
    private val localHouseDataSource: HouseDataSource
) : HouseRepository {

    private var inputHouse: House? = null

    override fun observeHouseList(): LiveData<MutableList<House>> {
        return localHouseDataSource.observeHouseList()
    }

    override fun observeHouse(id: String): LiveData<House?> {
        return localHouseDataSource.observeHouse(id)
    }

    override fun getHouse(id: String?): House? {
        return localHouseDataSource.getHouse(id)
    }

    override fun addHouse(house: House) {
        return localHouseDataSource.addHouse(house)
    }

    override fun updateHouse(house: House) {
        return localHouseDataSource.updateHouse(house)
    }
}