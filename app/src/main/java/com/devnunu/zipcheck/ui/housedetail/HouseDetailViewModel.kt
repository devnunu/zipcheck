package com.devnunu.zipcheck.ui.housedetail

import androidx.lifecycle.*
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import javax.inject.Inject

class HouseDetailViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

    private val houseId = MutableLiveData<String>()

    val house: LiveData<House> = houseId.switchMap {
        houseRepository.observeHouse(it)
    }

    val name = MutableLiveData<String>().apply {
        value = "name"
    }

    fun start(id: String) {
        houseId.value = id
    }
}