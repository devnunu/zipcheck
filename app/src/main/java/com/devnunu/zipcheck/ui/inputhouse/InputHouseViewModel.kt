package com.devnunu.zipcheck.ui.inputhouse

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.TransactionType
import com.devnunu.zipcheck.data.house.HouseRepository
import com.devnunu.zipcheck.data.house.model.CheckItem
import kotlinx.coroutines.launch

class InputHouseViewModel(
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
        if (!it.isNullOrEmpty()) {
            CurrencyUtil.toKrCurrencyText(it.toLong() * 10000, true)
        } else {
            "0 원"
        }
    }

    val monthlyPay = MutableLiveData<String>()

    val monthlyPayFormatText = monthlyPay.map {
        if (!it.isNullOrEmpty()) {
            CurrencyUtil.toKrCurrencyText(it.toLong() * 10000, true)
        } else {
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
    private val _onSuccessRegisterHouse = MutableLiveData<Event<Unit>>()
    val onSuccessRegisterHouse: LiveData<Event<Unit>> = _onSuccessRegisterHouse

    private fun checkIsBottomBtnEnable(): Boolean {
        return when (inputStep.value) {
            STEP_NAME -> name.value?.isEmpty()?.not() ?: false
            STEP_HOUSE_TYPE -> houseType.value?.isEmpty()?.not() ?: false
            STEP_DEPOSIT -> deposit.value?.isEmpty()?.not() ?: false
            STEP_MONTHLY_PAY -> monthlyPay.value?.isEmpty()?.not() ?: false
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
                if (houseType.value == TransactionType.LEASE_MONTHLY_PAY.displayName) {
                    increaseStep()
                } else {
                    registerHouse()
                    _onSuccessRegisterHouse.value = Event(Unit)
                }
            }
            STEP_MONTHLY_PAY -> {
                registerHouse()
                _onSuccessRegisterHouse.value = Event(Unit)
            }
            else -> false
        }
    }

    fun onChangeHouseType() {
        if (inputStep.value == STEP_HOUSE_TYPE) {
            increaseStep()
        }
    }

    private fun registerHouse() {
        viewModelScope.launch {
            houseRepository.insertHouse(getNewHouse())
        }
    }

    private fun getNewHouse(): House {
        val house = House(
            id = 0,
            name = this@InputHouseViewModel.name.value ?: "",
            transactionType = TransactionType.fromDisplayName(this@InputHouseViewModel.houseType.value),
            deposit = this@InputHouseViewModel.deposit.value?.toLong()?.times(10000),
            monthlyPay = this@InputHouseViewModel.monthlyPay.value?.toLong()?.times(10000),
            checklist = getNewChecklist()
        )
        return house
    }

    private fun getNewChecklist(): List<CheckItem> {
        return listOf(
            CheckItem("햇빛이 잘들어오나요"),
            CheckItem("물이 샌 흔적은 없나요"),
            CheckItem("환기가 잘되나요"),
            CheckItem("곰팡이가 핀곳은 없나요"),
            CheckItem("주변은 조용한가요"),
            CheckItem("집의 크기는 적당한가요"),
            CheckItem("냉장고, 세탁기 등, 가전을 놓을 자리가 있나요"),
            CheckItem("전등은 잘들어오나요"),
            CheckItem("수도는 잘나오나요(온수 포함)"),
            CheckItem("배수는 잘되나요"),
            CheckItem("파손된 시설은 없나요"),
            CheckItem("외풍이 심하지는 않나요"),
            CheckItem("방충망, 방범창이 있나요"),
            CheckItem("CCTV는 설치되어있나요"),
            CheckItem("주차장이 있나요"),
            CheckItem("교통이 편리한가요"),
            CheckItem("주변에 편의시설들이 있나요"),
            CheckItem("등기부등본상에 융자가 있나요"),
            CheckItem("관리비가 적당한가요"),
            CheckItem("집이 너무 외진곳은 아닌가요"),
            CheckItem("집을 내놨을때 잘 나갈수 있나요")
        )
    }
}