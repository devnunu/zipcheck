package com.devnunu.zipcheck.ui.home

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.house.HouseRepository

class HomeViewModel(
    private val houseRepository: HouseRepository
) : ViewModel() {

    val houseList = houseRepository.observeHouseList().distinctUntilChanged()

    val haveHouse = houseList.map {
        !it.isNullOrEmpty()
    }

    /** event */
    private val _onClickAddHouseBtn = MutableLiveData<Event<Unit>>()
    val onClickAddHouseBtn: LiveData<Event<Unit>> = _onClickAddHouseBtn


    /** 버튼 클릭 핸들러 */
    fun onClickAddHouseBtn() {
        _onClickAddHouseBtn.value = Event(Unit)
    }
}