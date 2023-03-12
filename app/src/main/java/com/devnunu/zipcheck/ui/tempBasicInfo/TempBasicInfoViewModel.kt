package com.devnunu.zipcheck.ui.tempBasicInfo

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.components.bottomSheet.BottomSheetState
import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.model.RoomType
import com.devnunu.zipcheck.data.repository.HouseRepository
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
    private val houseId: String,
    private val houseRepository: HouseRepository,
) : ContainerHost<TempBasicInfoState, Nothing>, ViewModel() {

    override val container = container<TempBasicInfoState, Nothing>(TempBasicInfoState())

    init {
        intent {
            houseRepository.getHouseListFlow().collect { houseList ->
                val house = houseList.firstOrNull { it.id == houseId }
                reduce {
                    state.copy(house = house)
                }
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

    fun onClickInputBottomSheetSaveBtn(
        tag: TempBasicInfoBottomSheetTag,
        value: String?,
        isChecked: Boolean?
    ) = intent {
        reduce {
            val house = state.house
            var changedHouse: House? = null
            if (value.isNullOrBlank() && isChecked == null) return@reduce state
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

            changedHouse?.let { house ->
                houseRepository.updateHouse(house)
                state.copy(house = house)
            } ?: state
        }
        onCloseBottomSheet()
    }

    fun onClickRoomType(roomType: RoomType) = intent {
        reduce {
            val changedHouse = state.house?.copy(roomType = roomType)
            changedHouse?.let { house ->
                houseRepository.updateHouse(house)
                state.copy(
                    house = changedHouse,
                    bottomSheetState = state.bottomSheetState.close()
                )
            } ?: state
        }
    }
}