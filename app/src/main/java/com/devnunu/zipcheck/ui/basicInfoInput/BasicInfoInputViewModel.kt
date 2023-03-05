package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.model.RoomArea
import com.devnunu.zipcheck.data.model.RoomAreaType
import com.devnunu.zipcheck.data.model.RoomType
import com.devnunu.zipcheck.data.repository.HouseRepository
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel.Companion.PAGE_FIRST
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class BasicInfoInputState(
    val currentPage: Int = PAGE_FIRST,
    val alias: String? = null,
    val roomType: RoomType = RoomType.TYPE_A,
    val roomArea: RoomArea = RoomArea(type = RoomAreaType.PYONG),
    val depositAmount: Long? = null,
    val monthlyAmount: Long? = null,
    val maintenanceCost: Long? = null,
    val memo: String? = null,
    val roomInfoUrl: String? = null,
    val isNoMonthlyAmount: Boolean = false,
    val isNoMaintenanceCost: Boolean = false,
) {
    val isBtnAndScrollEnable: Boolean
        get() = if (currentPage == PAGE_FIRST) {
            true
//            depositAmount != null && monthlyAmount != null
        } else {
            true
        }
}

class BasicInfoInputViewModel(
    private val houseRepository: HouseRepository,
) : ContainerHost<BasicInfoInputState, Nothing>, ViewModel() {

    override val container = container<BasicInfoInputState, Nothing>(BasicInfoInputState())

    fun onPageChange(currentPage: Int) = intent {
        reduce { state.copy(currentPage = currentPage) }
    }

    fun onChangeAlias(alias: String) = intent {
        reduce { state.copy(alias = alias) }
    }

    fun onClickRoomType(roomType: RoomType) = intent {
        reduce { state.copy(roomType = roomType) }
    }

    fun onChangeRoomArea(value: String) = intent {
        reduce {
            state.copy(
                roomArea = state.roomArea.copy(value = value)
            )
        }
    }

    fun onClickChangeRoomAreaType() = intent {
        val roomArea = state.roomArea
        reduce {
            state.copy(
                roomArea = roomArea.copy(
                    value = roomArea.transformValue.toString(),
                    type = roomArea.transformType
                )
            )
        }
    }

    fun onChangeDepositAmount(depositAmount: String) = intent {
        reduce { state.copy(depositAmount = depositAmount.toLongOrNull()) }
    }

    fun onChangeMonthlyAmount(monthlyAmount: String) = intent {
        reduce { state.copy(monthlyAmount = monthlyAmount.toLongOrNull()) }
    }

    fun onChangeMaintenanceCost(maintenanceCost: String) = intent {
        reduce { state.copy(maintenanceCost = maintenanceCost.toLongOrNull()) }
    }

    fun onClickNoMonthlyAmount(
        isNoMonthlyAmount: Boolean
    ) = intent {
        reduce {
            state.copy(
                monthlyAmount = 0,
                isNoMonthlyAmount = isNoMonthlyAmount
            )
        }
    }

    fun onClickNoMaintenanceCost(
        isNoMaintenanceCost: Boolean
    ) = intent {
        reduce {
            state.copy(
                monthlyAmount = 0,
                isNoMaintenanceCost = isNoMaintenanceCost
            )
        }
    }

    fun onChangeMemo(memo: String) = intent {
        reduce {
            state.copy(memo = memo)
        }
    }

    fun onChangeRoomInfoUrl(roomInfoUrl: String?) = intent {
        reduce {
            state.copy(roomInfoUrl = roomInfoUrl)
        }
    }

    fun addHouse(
        onSuccess: (String) -> Unit
    ) = intent {
        val house = getHouse(state)
        houseRepository.addHouse(house)
        onSuccess(house.id)
    }

    private fun getHouse(state: BasicInfoInputState): House =
        House(
            alias = state.alias,
            roomType = state.roomType,
            roomArea = state.roomArea,
            depositAmount = state.depositAmount,
            monthlyAmount = state.monthlyAmount,
            maintenanceCost = state.maintenanceCost,
            memo = state.memo,
            roomInfoUrl = state.roomInfoUrl,
        )

    companion object {
        const val PAGE_FIRST = 0
        const val PAGE_SECOND = 1
    }
}