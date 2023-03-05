package com.devnunu.zipcheck.ui.home

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.model.HouseWriteStatus
import com.devnunu.zipcheck.data.repository.HouseRepository
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class HomeState(
    val currentSortStatus: HouseWriteStatus = HouseWriteStatus.IN_PROGRESS,
    val title: String? = "home",
    val houseList: List<House> = emptyList()
) {
    val filteredHouseList: List<House>
        get() = houseList.filter { house ->
            house.houseWriteStatus == currentSortStatus
        }
}

class HomeViewModel(
    private val houseRepository: HouseRepository,
) : ContainerHost<HomeState, Nothing>, ViewModel() {

    override val container = container<HomeState, Nothing>(HomeState())

    init {
        intent {
            houseRepository.getHouseListFlow().collect { houseList ->
                reduce {
                    state.copy(houseList = houseList)
                }
            }
        }
    }

    fun onClickIndicator(houseWriteStatus: HouseWriteStatus) = intent {
        reduce {
            state.copy(currentSortStatus = houseWriteStatus)
        }
    }
}