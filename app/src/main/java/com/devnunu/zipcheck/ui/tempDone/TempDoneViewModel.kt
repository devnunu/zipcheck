package com.devnunu.zipcheck.ui.tempDone

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.model.HouseWriteStatus
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class TempDoneState(
    val house: House? = null,
)

class TempDoneViewModel(
    private val houseId: String,
    private val houseRepository: HouseRepository,
) : ContainerHost<TempDoneState, Nothing>, ViewModel() {

    override val container = container<TempDoneState, Nothing>(TempDoneState())


    fun onClickChangeHouseStatusFail(
        onSuccess: () -> Unit
    ) {
        houseRepository.updateHouseStatus(houseId, HouseWriteStatus.FAIL)
        onSuccess()
    }
}