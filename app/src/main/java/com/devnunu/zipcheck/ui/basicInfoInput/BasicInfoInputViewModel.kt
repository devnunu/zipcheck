package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.RoomArea
import com.devnunu.zipcheck.data.RoomAreaType
import com.devnunu.zipcheck.data.RoomType
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel.Companion.PAGE_FIRST
import com.devnunu.zipcheck.ui.home.HomeState
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
    val isNoMonthlyAmount: Boolean = false,
    val isNoMaintenanceCost: Boolean = false,
) {
    val isBtnAndScrollEnable: Boolean
        get() = if (currentPage == PAGE_FIRST) {
            depositAmount != null && monthlyAmount != null
        } else {
            true
        }
}

class BasicInfoInputViewModel : ContainerHost<BasicInfoInputState, Nothing>, ViewModel() {

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

    companion object {
        const val PAGE_FIRST = 0
        const val PAGE_SECOND = 1
    }

}