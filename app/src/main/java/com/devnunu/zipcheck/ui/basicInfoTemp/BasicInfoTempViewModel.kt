package com.devnunu.zipcheck.ui.basicInfoTemp

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.components.bottomSheet.BottomSheetState
import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.model.RoomType
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

enum class BasicInfoTempBottomSheetTag {
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

data class BasicInfoTempState(
    val house: House? = null,
    val bottomSheetState: BottomSheetState<BasicInfoTempBottomSheetTag> =
        BottomSheetState.Closed(null)
)

class BasicInfoTempViewModel(
    private val houseId: String,
    private val houseRepository: HouseRepository,
) : ContainerHost<BasicInfoTempState, Nothing>, ViewModel() {

    override val container = container<BasicInfoTempState, Nothing>(BasicInfoTempState())

    /**
     * Bottom Sheet
     * */
    fun onCloseBottomSheet() = intent {
        reduce { state.copy(bottomSheetState = state.bottomSheetState.close()) }
    }

    fun onClickOpenBottomSheet(tag: BasicInfoTempBottomSheetTag) = intent {
        reduce { state.copy(bottomSheetState = state.bottomSheetState.open(tag)) }
    }

    fun onClickInputBottomSheetSaveBtn(
        tag: BasicInfoTempBottomSheetTag,
        value: String?,
        isChecked: Boolean?
    ) = intent {
        reduce {
            val house = state.house
            when (tag) {
                BasicInfoTempBottomSheetTag.ALIAS -> {
                    state.copy(house = house?.copy(alias = value))
                }
                BasicInfoTempBottomSheetTag.MEMO -> {
                    state.copy(house = house?.copy(memo = value))
                }
                BasicInfoTempBottomSheetTag.ROOM_INFO_URL -> {
                    state.copy(house = house?.copy(roomInfoUrl = value))
                }
                BasicInfoTempBottomSheetTag.DEPOSIT_AMOUNT -> {
                    state.copy(house = house?.copy(depositAmount = value?.toLongOrNull()))
                }
                BasicInfoTempBottomSheetTag.MONTHLY_AMOUNT -> {
                    val value = if (isChecked == true) value?.toLongOrNull() else null
                    state.copy(house = house?.copy(monthlyAmount = value))
                }
                BasicInfoTempBottomSheetTag.MAINTENANCE_COST -> {
                    val value = if (isChecked == true) value?.toLongOrNull() else null
                    state.copy(house = house?.copy(maintenanceCost = value))
                }
                else -> state
            }
        }
        onCloseBottomSheet()
    }

    fun onClickRoomType(roomType:RoomType) = intent {
        reduce {
            state.copy(
                house = state.house?.copy(roomType = roomType),
                bottomSheetState = state.bottomSheetState.close()
            )
        }
    }

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
}