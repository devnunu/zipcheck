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
            when (tag) {
                TempBasicInfoBottomSheetTag.ALIAS -> {
                    state.copy(house = house?.copy(alias = value))
                }
                TempBasicInfoBottomSheetTag.MEMO -> {
                    state.copy(house = house?.copy(memo = value))
                }
                TempBasicInfoBottomSheetTag.ROOM_INFO_URL -> {
                    state.copy(house = house?.copy(roomInfoUrl = value))
                }
                TempBasicInfoBottomSheetTag.DEPOSIT_AMOUNT -> {
                    state.copy(house = house?.copy(depositAmount = value?.toLongOrNull()))
                }
                TempBasicInfoBottomSheetTag.MONTHLY_AMOUNT -> {
                    val value = if (isChecked == true) value?.toLongOrNull() else null
                    state.copy(house = house?.copy(monthlyAmount = value))
                }
                TempBasicInfoBottomSheetTag.MAINTENANCE_COST -> {
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
}