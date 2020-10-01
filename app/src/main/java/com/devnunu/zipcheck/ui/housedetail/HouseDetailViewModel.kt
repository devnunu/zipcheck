package com.devnunu.zipcheck.ui.housedetail

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType
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
        when (it?.houseType) {
            HouseType.LEASE_MONTHLY_PAY ->
                "${it.houseType?.displayName} ${CurrencyUtil.toKrCurrencyText(it.deposit)}" +
                        "/${CurrencyUtil.toKrCurrencyText(it.monthlyPay)}"
            else -> "${it?.houseType?.displayName} ${CurrencyUtil.toKrCurrencyText(it?.deposit)}"
        }
    }

    val checklist = house.map {
        it?.checklist
    }

    /** data loading start */
    fun start(id: Int) {
        houseId.value = id
    }

    /** click handler */
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
}