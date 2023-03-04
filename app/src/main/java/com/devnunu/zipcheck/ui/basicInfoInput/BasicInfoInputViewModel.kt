package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.lifecycle.ViewModel
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
    val roomType: RoomType = RoomType.TYPE_A
)

class BasicInfoInputViewModel : ContainerHost<BasicInfoInputState, Nothing>, ViewModel() {

    override val container = container<BasicInfoInputState, Nothing>(BasicInfoInputState())

    fun onChangeAlias(alias: String) = intent {
        reduce { state.copy(alias = alias) }
    }

    fun onClickRoomType(roomType: RoomType) = intent {
        reduce { state.copy(roomType = roomType) }
    }

    companion object {
        const val PAGE_FIRST = 0
        const val PAGE_SECOND = 1
    }

}