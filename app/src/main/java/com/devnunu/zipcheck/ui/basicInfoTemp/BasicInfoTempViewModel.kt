package com.devnunu.zipcheck.ui.basicInfoTemp

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class BasicInfoTempState(
    val house: House? = null
)

class BasicInfoTempViewModel(
    private val houseId: String,
    private val houseRepository: HouseRepository,
) : ContainerHost<BasicInfoTempState, Nothing>, ViewModel() {

    override val container = container<BasicInfoTempState, Nothing>(BasicInfoTempState())

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