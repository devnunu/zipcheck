package com.example.myapplication.ui.inputhouse

import androidx.lifecycle.*
import com.example.myapplication.data.house.repo.HouseRepository
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


    private fun changeTitle(): String {
        return ""
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

    val monthlyPay = MutableLiveData<String>()

    val isBottomBtnEnable = MediatorLiveData<Boolean>().apply {
        addSource(name) { value = checkIsBottomBtnEnable() }
        addSource(houseType) { value = checkIsBottomBtnEnable() }
        addSource(deposit) { value = checkIsBottomBtnEnable() }
        addSource(monthlyPay) { value = checkIsBottomBtnEnable() }
    }

    private fun checkIsBottomBtnEnable(): Boolean {
        // TODO:각 step 별로 다음 버튼 검증 로직 추가
        return true
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
        increaseStep()
    }

}