package com.devnunu.zipcheck.ui.inputhouse

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import java.lang.NumberFormatException
import javax.inject.Inject

class InputHouseViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

    companion object {
        const val STEP_NAME = 1
        const val STEP_HOUSE_TYPE = 2
        const val STEP_DEPOSIT = 3
        const val STEP_MONTHLY_PAY = 4
    }


    private val _inputStep = MutableLiveData<Int>()
    val inputStep: LiveData<Int> = _inputStep

    val title = inputStep.map {
        when (it) {
            STEP_NAME -> "집 이름을 입력해 주세요"
            STEP_HOUSE_TYPE -> "매물 유형을 입력해주세요"
            STEP_DEPOSIT -> "보증금을 입력해주세요"
            STEP_MONTHLY_PAY -> "월세를 입력해주세요"
            else -> null
        }
    }

    val name = MutableLiveData<String>()

    val houseType = MutableLiveData<String>()

    val deposit = MutableLiveData<String>()

    val depositFormatText = deposit.map {
        try {
            CurrencyUtil.toKrCurrencyText(it.toLong(), true)
        } catch (e: NumberFormatException) {
            "0 원"
        }
    }

    val monthlyPay = MutableLiveData<String>()

    val monthlyPayFormatText = monthlyPay.map {
        try {
            CurrencyUtil.toKrCurrencyText(it.toLong(), true)
        } catch (e: NumberFormatException) {
            "0 원"
        }
    }

    val isBottomBtnEnable = MediatorLiveData<Boolean>().apply {
        addSource(name) { value = checkIsBottomBtnEnable() }
        addSource(houseType) { value = checkIsBottomBtnEnable() }
        addSource(deposit) { value = checkIsBottomBtnEnable() }
        addSource(monthlyPay) { value = checkIsBottomBtnEnable() }
        addSource(inputStep) { value = checkIsBottomBtnEnable() }
    }

    /** event */
    private val _onClickNextBtn = MutableLiveData<Event<Unit>>()
    val onClickNextBtn: LiveData<Event<Unit>> = _onClickNextBtn

    private fun checkIsBottomBtnEnable(): Boolean {
        return when (inputStep.value) {
            STEP_NAME -> name.value?.isNullOrEmpty()?.not() ?: false
            STEP_HOUSE_TYPE -> houseType.value?.isNullOrEmpty()?.not() ?: false
            STEP_DEPOSIT -> deposit.value?.isNullOrEmpty()?.not() ?: false
            STEP_MONTHLY_PAY -> monthlyPay.value?.isNullOrEmpty()?.not() ?: false
            else -> false
        }
    }

    init {
        _inputStep.value = STEP_NAME
    }

    private fun increaseStep() {
        val step = _inputStep.value
        _inputStep.value = step?.plus(1)
    }

    /** click event handlers */
    fun onClickBottomBtn() {
        when (inputStep.value) {
            STEP_NAME,
            STEP_HOUSE_TYPE -> increaseStep()
            STEP_DEPOSIT -> {
                if (houseType == HouseType.LEASE_MONTHLY_PAY) {
                    increaseStep()
                } else {
                    saveHouseInfo()
                    _onClickNextBtn.value = Event(Unit)
                }
            }
            STEP_MONTHLY_PAY -> _onClickNextBtn.value = Event(Unit)
            else -> false
        }
    }

    private fun saveHouseInfo() {
        val house = House().apply {
            name = this@InputHouseViewModel.name.value ?: ""
            houseType = HouseType.fromDisplayName(this@InputHouseViewModel.houseType.value)
            deposit = this@InputHouseViewModel.deposit.value?.toLong() ?: 0
            monthlyPay = this@InputHouseViewModel.monthlyPay.value?.toLong() ?: 0
        }
    }

}