package com.devnunu.zipcheck.ui.housedetail

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.ui.housedetail.category.HouseChecklistItemListener
import javax.inject.Inject

class HouseDetailViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel(), HouseChecklistItemListener {

    private val houseId = MutableLiveData<String>()

    val house: LiveData<House?> = houseId.switchMap {
        houseRepository.observeHouse(it)
    }

    val typeAndPriceText = house.map {
        when (it?.houseType) {
            HouseType.LEASE_MONTHLY_PAY ->
                "${it.houseType?.displayName} ${CurrencyUtil.toKrCurrencyText(it.deposit)}/${CurrencyUtil.toKrCurrencyText(
                    it.monthlyPay
                )}"
            else -> "${it?.houseType?.displayName} ${CurrencyUtil.toKrCurrencyText(it?.deposit)}"
        }
    }

    val checklist = house.map {
        it?.checklist
    }

    val categoryNameList = house.map {
        it?.checklist?.items?.keys?.toList()
    }

    val checkItemProgress = house.map {
        val checkedGoodCount = getItemCountByStatus(it, true)
        val itemCountText = getTotalItemCount(it)
        if (checkedGoodCount == 0 || itemCountText == 0) 0
        else checkedGoodCount * 100 / itemCountText
    }

    val totalItemCountText = house.map {
        "${getTotalItemCount(it)} 개"
    }

    val goodItemCountText = house.map {
        "${getItemCountByStatus(it, true)} 개"
    }

    val badItemCountText = house.map {
        "${getItemCountByStatus(it, false)} 개"
    }

    private fun getItemCountByStatus(house: House?, status: Boolean): Int {
        val checklistItems = house?.checklist?.items
        val keys = checklistItems?.keys
        return keys
            ?.mapNotNull { key ->
                checklistItems[key]?.filter { checkItem -> checkItem.isGood == status }?.size
            }
            ?.sumBy { count -> count } ?: 0
    }

    private fun getTotalItemCount(house: House?): Int {
        val checklistItems = house?.checklist?.items
        return checklistItems?.keys
            ?.mapNotNull { key -> checklistItems[key]?.size }
            ?.sumBy { count -> count } ?: 0
    }

    /** event */
    private val _onClickAddChecklistBtn = MutableLiveData<Event<Unit>>()
    val onClickAddChecklistBtn: LiveData<Event<Unit>> = _onClickAddChecklistBtn

    /** data loading start */
    fun start(id: String) {
        houseId.value = id
    }


    /** click handler */
    fun onClickAddChecklistBtn() {
        _onClickAddChecklistBtn.value = Event(Unit)
    }

    override fun onClickCheckItem(categoryName: String?, itemId: String?, isGood: Boolean?) {
        val house = house.value
        if (house != null) {
            house.checklist?.items?.get(categoryName)?.forEach {
                if (it.id == itemId) {
                    it.isGood = isGood
                }
            }
            houseRepository.updateHouse(house)
        }
    }
}