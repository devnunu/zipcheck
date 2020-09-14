package com.devnunu.zipcheck.ui.housedetail

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.ui.housedetail.item.ChecklistItemListener

class HouseDetailViewModel(
    private val houseRepository: HouseRepository
) : ViewModel(), ChecklistItemListener {

    private val houseId = MutableLiveData<String>()

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
        it?.template
    }

    val checkItemProgress = house.map {
        val checkedGoodCount = 0
        val itemCountText = 0
        if (checkedGoodCount == 0 || itemCountText == 0) 0
        else checkedGoodCount * 100 / itemCountText
    }

    val totalItemCountText = house.map {
        "${0} 개"
    }

    val goodItemCountText = house.map {
        "${0} 개"
    }

    val badItemCountText = house.map {
        "${0} 개"
    }

    /** event */
    private val _onClickAddChecklistBtn = MutableLiveData<Event<String>>()
    val onClickAddChecklistBtn: LiveData<Event<String>> = _onClickAddChecklistBtn

    /** data loading start */
    fun start(id: String) {
        houseId.value = id
    }

    /** click handler */
    fun onClickAddChecklistBtn() {
        houseId.value?.let {
            _onClickAddChecklistBtn.value = Event(it)
        }
    }

    override fun onClickCheck(id: String) {
        TODO("Not yet implemented")
    }
}