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

    private val _houseId = MutableLiveData<Int>()

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

    private val _onSuccessUpdateHouse = MutableLiveData<Event<Unit>>()
    val onSuccessUpdateHouse: LiveData<Event<Unit>> = _onSuccessUpdateHouse

    /**
     * 초기화
     * */
    fun start(houseId: Int) {
        _houseId.value = houseId
        viewModelScope.launch {
            val house: House = houseRepository.getHouse(houseId)
            _parking.value = when (house.parking) {
                true -> "가능"
                false -> "불가"
                else -> null
            }
            _elevator.value = when (house.elevator) {
                true -> "있음"
                false -> "없음"
                else -> null
            }
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

    fun onClickConfirmBtn() {
        viewModelScope.launch {
            val houseId = _houseId.value ?: 0
            val newHouse: House? = houseRepository.getHouse(houseId)
            newHouse?.let {
                it.parking = when (_parking.value) {
                    "가능" -> true
                    "불가" -> false
                    else -> null
                }
                it.elevator = when (_elevator.value) {
                    "있음" -> true
                    "없음" -> false
                    else -> null
                }
                it.managementFee = managementFee.value?.toInt()
                it.houseType = HouseType.fromDisplayName(_houseType.value)
                it.area = area.value?.toInt()
                it.floor = floor.value?.toInt()
                it
            }

            newHouse?.let {
                houseRepository.updateHouse(it)
            }
            _onSuccessUpdateHouse.value = Event(Unit)
        }
    }
}