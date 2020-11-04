package com.devnunu.zipcheck.ui.home

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.house.HouseRepository

class HomeViewModel(
    houseRepository: HouseRepository
) : ViewModel() {

    val houseList = houseRepository.observeHouseList().distinctUntilChanged()

    val haveHouse = houseList.map {
        !it.isNullOrEmpty()
    }

    val title = MutableLiveData<String>("${getEmoji(0x1F3E0)} 집 목록")

    /** event */
    private val _onClickAddHouseBtn = MutableLiveData<Event<Unit>>()
    val onClickAddHouseBtn: LiveData<Event<Unit>> = _onClickAddHouseBtn

    /**
     * 이모지 변환 함수
     * */
    fun getEmoji(unicode: Int): String {
        return String(Character.toChars(unicode))
    }

    /**
     * 버튼 클릭 핸들러
     * */
    fun onClickAddHouseBtn() {
        _onClickAddHouseBtn.value = Event(Unit)
    }
}