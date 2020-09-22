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

    val checkItemProgress = house.map {
        val totalChecklistCount = it?.checklist?.items?.size ?: 0
        val checkItemCount = it?.checklist?.items?.filter { item -> item.isGood != null }?.size ?: 0
        if (totalChecklistCount == 0) {
            0
        } else {
            checkItemCount * 100 / totalChecklistCount
        }
    }

    val totalItemCountText = house.map {
        "${it?.checklist?.items?.size ?: 0} 개"
    }

    val goodItemCountText = house.map {
        "${getItemCountByStatus(it, true)} 개"
    }

    val badItemCountText = house.map {
        "${getItemCountByStatus(it, false)} 개"
    }

    val checklistBtnText = checklist.map {
        if (it != null) "변경하기" else "추가하기"
    }

    /** event */
    private val _onClickAddChecklistBtn = MutableLiveData<Event<Int>>()
    val onClickAddChecklistBtn: LiveData<Event<Int>> = _onClickAddChecklistBtn

    /** data loading start */
    fun start(id: Int) {
        houseId.value = id
    }

    private fun getItemCountByStatus(house: House?, status: Boolean): Int {
        val checklistItems = house?.checklist?.items
        return checklistItems
            ?.filter { item ->
                item.isGood == status
            }?.size ?: 0
    }

    /** click handler */
    fun onClickAddChecklistBtn() {
        houseId.value?.let {
            _onClickAddChecklistBtn.value = Event(it)
        }
    }

    override fun onClickCheck(id: String, isGood: Boolean) {
        viewModelScope.launch {
            val houseId = houseId.value
            val checklist = house.value?.checklist
            checklist?.items?.forEach {
                if (it.id == id) it.isGood = isGood
            }

            if(houseId!=null && checklist!=null) {
                houseRepository.updateHouseChecklist(houseId, checklist)
            }
        }
    }
}