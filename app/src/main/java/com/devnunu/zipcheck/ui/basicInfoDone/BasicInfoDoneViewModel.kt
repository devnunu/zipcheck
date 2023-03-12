package com.devnunu.zipcheck.ui.basicInfoDone

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.common.orbit.EmptyState
import com.devnunu.zipcheck.data.model.HouseWriteStatus
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container

class BasicInfoDoneViewModel(
    private val houseId: String,
    private val houseRepository: HouseRepository
) : ContainerHost<EmptyState, Nothing>, ViewModel() {

    override val container = container<EmptyState, Nothing>(EmptyState())

    fun onClickChangeHouseStatusFail(
        onSuccess: () -> Unit
    ) = intent {
        houseRepository.updateHouseStatus(houseId, HouseWriteStatus.FAIL)
        onSuccess()
    }
}