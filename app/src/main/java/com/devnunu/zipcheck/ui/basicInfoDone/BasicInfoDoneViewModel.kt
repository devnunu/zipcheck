package com.devnunu.zipcheck.ui.basicInfoDone

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.common.orbit.EmptyState
import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.model.HouseWriteStatus
import com.devnunu.zipcheck.data.model.Summary
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class BasicInfoDone(
    val house: House? = null
)

class BasicInfoDoneViewModel(
    private val houseId: String,
    private val houseRepository: HouseRepository
) : ContainerHost<BasicInfoDone, Nothing>, ViewModel() {

    override val container = container<BasicInfoDone, Nothing>(BasicInfoDone())

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

    fun onClickChangeHouseStatusFail(
        onSuccess: () -> Unit
    ) = intent {
        val house = state.house?.copy(houseWriteStatus = HouseWriteStatus.FAIL)
        house?.let {
            houseRepository.updateHouse(house)
            onSuccess()
        }
    }
}