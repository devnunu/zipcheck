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

    /** event*/
    private val _onClickDeleteBtn = MutableLiveData<Event<Unit>>()
    val onClickDeleteBtn: LiveData<Event<Unit>> = _onClickDeleteBtn

    private val _onSuccessDeleteHouse = MutableLiveData<Event<Unit>>()
    val onSuccessDeleteHouse: LiveData<Event<Unit>> = _onSuccessDeleteHouse

    private val _onClickAddPhotos = MutableLiveData<Event<Unit>>()
    val onClickAddPhotos: LiveData<Event<Unit>> = _onClickAddPhotos

    /** data loading start */
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


    /** click handler */
    fun onClickDeleteBtn() {
        _onClickDeleteBtn.value = Event(Unit)
    }

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