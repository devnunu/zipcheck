package com.devnunu.zipcheck.ui.tempBasicInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devnunu.zipcheck.components.bottomSheet.BottomSheetState
import com.devnunu.zipcheck.data.model.common.ResResult
import com.devnunu.zipcheck.data.model.house.HouseType
import com.devnunu.zipcheck.data.model.house.House
import com.devnunu.zipcheck.data.repository.HouseRepository
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

enum class TempBasicInfoBottomSheetTag {
    ALIAS,
    VISIT_DATE,
    LOCATION,
    MEMO,
    ROOM_TYPE,
    ROOM_INFO_URL,
    ROOM_AREA,
    DEPOSIT_AMOUNT,
    MONTHLY_AMOUNT,
    MAINTENANCE_COST
}

data class TempBasicInfoState(
    val house: House? = null,
    val bottomSheetState: BottomSheetState<TempBasicInfoBottomSheetTag> =
        BottomSheetState.Closed(null)
)

class TempBasicInfoViewModel(
    private val houseId: Long,
    private val houseRepository: HouseRepository,
) : ContainerHost<TempBasicInfoState, Nothing>, ViewModel() {

    override val container = container<TempBasicInfoState, Nothing>(TempBasicInfoState())

    init {
        collectDataFlow()
    }

    private fun collectDataFlow() = intent {
        houseRepository.getHouseFlow(houseId).collect { house ->
            reduce {
                state.copy(house = house)
            }
        }
    }

    /**
     * Bottom Sheet
     * */
    fun onCloseBottomSheet() = intent {
        reduce { state.copy(bottomSheetState = state.bottomSheetState.close()) }
    }

    fun onClickOpenBottomSheet(tag: TempBasicInfoBottomSheetTag) = intent {
        reduce { state.copy(bottomSheetState = state.bottomSheetState.open(tag)) }
    }

    /**
     * Update Values
     * */
    fun onClickInputBottomSheetSaveBtn(
        tag: TempBasicInfoBottomSheetTag,
        value: String?,
        isChecked: Boolean?
    ) = intent {
        if (value.isNullOrBlank() && isChecked == null) return@intent
        val house = state.house
        var changedHouse: House? = null
        when (tag) {
            TempBasicInfoBottomSheetTag.ALIAS -> {
                changedHouse = house?.copy(alias = value)
            }
            TempBasicInfoBottomSheetTag.MEMO -> {
                changedHouse = house?.copy(memo = value)
            }
            TempBasicInfoBottomSheetTag.ROOM_INFO_URL -> {
                changedHouse = house?.copy(roomInfoUrl = value)
            }
            TempBasicInfoBottomSheetTag.DEPOSIT_AMOUNT -> {
                changedHouse = house?.copy(depositAmount = value?.toLongOrNull()?.times(10000))
            }
            TempBasicInfoBottomSheetTag.MONTHLY_AMOUNT -> {
                val value = if (isChecked == true) 0L else value?.toLongOrNull()?.times(10000)
                changedHouse = house?.copy(monthlyAmount = value)
            }
            TempBasicInfoBottomSheetTag.MAINTENANCE_COST -> {
                val value = if (isChecked == true) 0L else value?.toLongOrNull()?.times(10000)
                changedHouse = house?.copy(maintenanceCost = value)
            }
            else -> state
        }
        updateHouse(changedHouse)
        onCloseBottomSheet()
    }

    private fun updateHouse(changedHouse: House?) = intent {
        changedHouse?.let { house ->
            houseRepository.updateHouse(house)
            reduce { state.copy(house = house) }
        }
    }

    fun onClickHouseType(houseType: HouseType) = intent {
        val changedHouse = state.house?.copy(houseType = houseType)
        updateHouse(changedHouse)
        onCloseBottomSheet()
    }
}