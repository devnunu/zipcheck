package com.devnunu.zipcheck.ui.basicInfoDone

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.common.orbit.EmptyState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class BasicInfoDoneViewModel: ContainerHost<EmptyState, Nothing>, ViewModel() {

    override val container = container<EmptyState, Nothing>(EmptyState())
}