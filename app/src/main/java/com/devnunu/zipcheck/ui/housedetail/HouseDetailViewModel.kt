package com.devnunu.zipcheck.ui.housedetail

import android.net.Uri
import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.TransactionType
import com.devnunu.zipcheck.data.house.HouseRepository
import kotlinx.coroutines.launch

class HouseDetailViewModel(
    private val houseRepository: HouseRepository
) : ViewModel() {

    private val houseId = MutableLiveData<Int>()

    val house: LiveData<House?> = houseId.switchMap {
        houseRepository.observeHouse(it)
    }

    val typeAndPriceText = house.map {
        when (it?.transactionType) {
            TransactionType.LEASE_MONTHLY_PAY ->
                "${it.transactionType?.displayName} ${CurrencyUtil.toKrCurrencyText(it.deposit)}" +
                        "/${CurrencyUtil.toKrCurrencyText(it.monthlyPay)}"
            else -> "${it?.transactionType?.displayName} ${CurrencyUtil.toKrCurrencyText(it?.deposit)}"
        }
    }

    val checklist = house.map {
        it?.checklist
    }

    private val _imageUriList = MutableLiveData<List<Uri>>(listOf())
    val imageUriList: LiveData<List<Uri>> = _imageUriList

    val parkingText = house.map {
        when (it?.parking) {
            null -> "-"
            true -> "가능"
            else -> "불가능"
        }
    }

    val elevator = house.map {
        when (it?.elevator) {
            null -> "-"
            true -> "있음"
            else -> "없음"
        }
    }

    val managementFee = house.map {
        when (it?.managementFee) {
            null -> "-"
            else -> "${it?.managementFee}만원"
        }
    }

    val structure = house.map {
        when (it?.structure) {
            null -> "-"
            else -> it.structure.displayName
        }
    }

    val area = house.map {
        when (it?.area) {
            null -> "-"
            else -> "${it.area}평"
        }
    }

    val floor = house.map {
        when (it?.floor) {
            null -> "-"
            else -> "${it?.floor}층"
        }
    }

    val houseType = house.map {
        when (it?.houseType) {
            null -> "-"
            else -> it?.houseType.displayName
        }
    }

    /**
     * event
     * */
    private val _onSuccessDeleteHouse = MutableLiveData<Event<Unit>>()
    val onSuccessDeleteHouse: LiveData<Event<Unit>> = _onSuccessDeleteHouse

    private val _onClickAddPhotos = MutableLiveData<Event<Unit>>()
    val onClickAddPhotos: LiveData<Event<Unit>> = _onClickAddPhotos

    /**
     * data loading start
     * */
    fun start(id: Int) {
        houseId.value = id
    }

    fun deleteHouse() {
        viewModelScope.launch {
            houseId.value?.let {
                houseRepository.deleteHouse(it)
                _onSuccessDeleteHouse.value = Event(Unit)
            }
        }
    }

    fun setImageUriList(list: List<Uri>) {
        val imageUriList = _imageUriList.value ?: listOf()
        _imageUriList.value = imageUriList + list
    }

    fun getImageUriListSize(): Int {
        return _imageUriList.value?.size ?: 0
    }

    fun getHouseId(): Int? {
        return houseId.value
    }


    /**
     * click handler
     * */
    fun onClickRate(index: Int, point: Int) {
        viewModelScope.launch {
            val houseId = houseId.value
            val checklist = house.value?.checklist
            checklist?.get(index)?.point = point
            if (houseId != null && checklist != null) {
                houseRepository.updateHouseChecklist(houseId, checklist)
            }
        }
    }

    fun onClickAddPhotos() {
        _onClickAddPhotos.value = Event(Unit)
    }
}