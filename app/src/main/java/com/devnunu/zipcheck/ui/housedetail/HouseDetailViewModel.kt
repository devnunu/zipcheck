package com.devnunu.zipcheck.ui.housedetail

import androidx.lifecycle.*
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.ui.housedetail.category.HouseChecklistItemListener
import javax.inject.Inject

class HouseDetailViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel(), HouseChecklistItemListener {

    private val houseId = MutableLiveData<String>()

    val house: LiveData<House> = houseId.switchMap {
        houseRepository.observeHouse(it)
    }

    val checklist = house.map {
        it.checklist
    }

    val categoryNameList = house.map {
        it.checklist?.items?.keys?.toList()
    }

    val name = MutableLiveData<String>().apply {
        value = "name"
    }

    fun start(id: String) {
        houseId.value = id
    }
}