package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.Event
import com.example.myapplication.data.house.repo.HouseRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

    val houseList = houseRepository.observeHouseList()

    /** event */
    private val _onClickAddHouseBtn = MutableLiveData<Event<Unit>>()
    val onClickAddHouseBtn: LiveData<Event<Unit>> = _onClickAddHouseBtn


    /** 버튼 클릭 핸들러 */
    fun onClickAddHouseBtn() {
        _onClickAddHouseBtn.value = Event(Unit)
    }
}