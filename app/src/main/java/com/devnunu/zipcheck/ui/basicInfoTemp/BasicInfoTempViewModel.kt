package com.devnunu.zipcheck.ui.basicInfoTemp

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.components.bottomSheet.BottomSheetState
import com.devnunu.zipcheck.data.model.house.House
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
    MAINTENANCE_AMOUNT
}

data class BasicInfoTempState(
    val house: House? = null,
    val bottomSheetState: BottomSheetState<BasicInfoTempBottomSheetTag> =
        BottomSheetState.Closed(BasicInfoTempBottomSheetTag.ALIAS)
)

class BasicInfoTempViewModel(
    private val houseId: Long,
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
                BasicInfoTempBottomSheetTag.ALIAS -> state.copy(house = house?.copy(alias = value))
                else -> state
            }
        }
        onCloseBottomSheet()
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