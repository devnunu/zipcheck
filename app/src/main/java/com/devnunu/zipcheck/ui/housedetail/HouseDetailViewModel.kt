package com.devnunu.zipcheck.ui.housedetail

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.data.house.HouseRepository
import com.devnunu.zipcheck.ui.housedetail.item.ChecklistItemListener
import kotlinx.coroutines.launch

class HouseDetailViewModel(
    private val houseRepository: HouseRepository
) : ViewModel(), ChecklistItemListener {

    private val houseId = MutableLiveData<Int>()

    val house: LiveData<House?> = houseId.switchMap {
        houseRepository.observeHouse(it)
    }

    val typeAndPriceText = house.map {
        when (it?.houseType) {
            HouseType.LEASE_MONTHLY_PAY ->
                "${it.houseType?.displayName} ${CurrencyUtil.toKrCurrencyText(it.deposit)}/${
                    CurrencyUtil.toKrCurrencyText(
                        it.monthlyPay
                    )
                }"
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
    override fun onClickCheck(name: String, point: Int) {
        viewModelScope.launch {
            val houseId = houseId.value
            val checklist = house.value?.checklist
            checklist?.forEach {
//                if (it.name == id) it.isGood = isGood
            }

            if(houseId!=null && checklist!=null) {
                houseRepository.updateHouseChecklist(houseId, checklist)
            }
        }
    }
}