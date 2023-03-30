package com.devnunu.zipcheck.ui.tempOption

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.components.bottomSheet.BottomSheetState
import com.devnunu.zipcheck.data.model.house.House
import com.devnunu.zipcheck.data.model.house.HouseOption
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

enum class TempOptionBottomSheetTag {
    OPTION
}

data class TempOptionState(
    val house: House? = null,
    val houseOptionItemList: List<HouseOption> = emptyList(),
    val bottomSheetState: BottomSheetState<TempOptionBottomSheetTag> =
        BottomSheetState.Closed(null)
)

class TempOptionViewModel(
    private val houseId: Long,
    private val houseRepository: HouseRepository,
) : ContainerHost<TempOptionState, Nothing>, ViewModel() {

    override val container = container<TempOptionState, Nothing>(TempOptionState())

    init {
        intent {
            houseRepository.getHouseListFlow().collect { houseList ->
                val house = houseList.firstOrNull { it.id == houseId }
                reduce {
                    state.copy(
                        house = house,
                        houseOptionItemList = house?.optionList.orEmpty()
                    )
                }
            }
        }
    }

    fun onClickItem(clickedHouseOptionItem: HouseOption) = intent {
        val houseOptionList = state.houseOptionItemList.toMutableList().map { houseOption ->
            if (houseOption == clickedHouseOptionItem) {
                houseOption.copy(isSelected = !houseOption.isSelected)
            } else {
                houseOption
            }
        }
        reduce {
            state.copy(houseOptionItemList = houseOptionList)
        }
    }

    fun onDeleteCustomOption(clickedHouseOptionItem: HouseOption) = intent {
        val houseOptionList = state.houseOptionItemList.toMutableList().filter { houseOption ->
            houseOption != clickedHouseOptionItem
        }
        reduce {
            state.copy(houseOptionItemList = houseOptionList)
        }
    }

    fun onClickCustomOptionConfirmBtn(optionName: String) = intent {
        val houseOptionList = state.houseOptionItemList.toMutableList()
        houseOptionList.add(HouseOption.makeCustomHouseOption(optionName))
        reduce {
            state.copy(
                houseOptionItemList = houseOptionList,
                bottomSheetState = state.bottomSheetState.close()
            )
        }
    }

    fun onClickNextBtn(
        onSuccess: () -> Unit
    ) = intent {
        val house = state.house?.copy(optionList = state.houseOptionItemList)
        house?.let { house ->
            houseRepository.updateHouse(house)
            onSuccess()
        }
    }

    /**
     * Bottom Sheet
     * */
    fun onCloseBottomSheet() = intent {
        reduce { state.copy(bottomSheetState = state.bottomSheetState.close()) }
    }

    fun onClickOpenBottomSheet(tag: TempOptionBottomSheetTag) = intent {
        reduce { state.copy(bottomSheetState = state.bottomSheetState.open(tag)) }
    }
}