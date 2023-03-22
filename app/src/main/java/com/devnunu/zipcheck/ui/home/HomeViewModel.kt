package com.devnunu.zipcheck.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devnunu.zipcheck.data.model.common.ResResult
import com.devnunu.zipcheck.data.model.house.House
import com.devnunu.zipcheck.data.model.house.HouseWriteStatus
import com.devnunu.zipcheck.data.model.user.User
import com.devnunu.zipcheck.data.repository.HouseRepository
import com.devnunu.zipcheck.data.repository.UserRepository
import kotlinx.coroutines.launch
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
    private val userRepository: UserRepository,
    private val houseRepository: HouseRepository,
) : ContainerHost<HomeState, Nothing>, ViewModel() {

    override val container = container<HomeState, Nothing>(HomeState())

    init {
        collectDataFlow()
        start()
    }

    private fun start() = viewModelScope.launch {
        val user = userRepository.getUser()
        if (user == null) {
            val result = userRepository.saveUser(User())
            if (result is ResResult.Success) {
                houseRepository.getAllHouseList()
            }
        }
    }

    private fun collectDataFlow() = intent {
        houseRepository.getHouseListFlow().collect { houseList ->
            reduce {
                state.copy(houseList = houseList)
            }
        }
    }

    fun onClickIndicator(houseWriteStatus: HouseWriteStatus) = intent {
        reduce {
            state.copy(currentSortStatus = houseWriteStatus)
        }
    }
}