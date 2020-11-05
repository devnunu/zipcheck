package com.devnunu.zipcheck.ui.houseedit

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.house.HouseRepository
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType
import kotlinx.coroutines.launch

class HouseEditViewModel(
    private val houseRepository: HouseRepository
) : ViewModel() {

    /**
     * View
     * */
    private val _parking = MutableLiveData<String>()
    val parking: LiveData<String> = _parking

    private val _elevator = MutableLiveData<String>()
    val elevator: LiveData<String> = _elevator

    val managementFee = MutableLiveData<String>()

    private val _houseType = MutableLiveData<String>()
    val houseType: LiveData<String> = _houseType

    val area = MutableLiveData<String>()

    val floor = MutableLiveData<String>()

    /**
     * Event
     * */
    private val _onClickParking = MutableLiveData<Event<Unit>>()
    val onClickParking: LiveData<Event<Unit>> = _onClickParking

    private val _onClickElevator = MutableLiveData<Event<Unit>>()
    val onClickElevator: LiveData<Event<Unit>> = _onClickElevator

    private val _onClickHouseType = MutableLiveData<Event<Unit>>()
    val onClickHouseType: LiveData<Event<Unit>> = _onClickHouseType

    /**
     * 초기화
     * */
    fun start(houseId: Int) {
        viewModelScope.launch {
            val house: House = houseRepository.getHouse(houseId)
            _parking.value = if (house.parking == true) "가능" else "불가"
            _elevator.value = if (house.elevator == true) "있음" else "없음"
        }
    }

    /**
     * 상태값 변경
     * */
    fun setParking(parking: String?) {
        _parking.value = parking
    }

    fun setElevator(elevator: String?) {
        _elevator.value = elevator
    }

    fun setHouseType(houseType: String?) {
        _houseType.value = houseType
    }

    /**
     * 버튼 클릭 핸들러
     * */
    fun onClickParkingSelector() {
        _onClickParking.value = Event(Unit)
    }

    fun onClickElevatorSelector() {
        _onClickElevator.value = Event(Unit)
    }

    fun onClickHouseType() {
        _onClickHouseType.value = Event(Unit)
    }
}