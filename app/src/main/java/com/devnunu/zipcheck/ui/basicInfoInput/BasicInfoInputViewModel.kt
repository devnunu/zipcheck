package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel.Companion.PAGE_FIRST
import com.devnunu.zipcheck.ui.home.HomeState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class BasicInfoInputState(
    val currentPage: Int = PAGE_FIRST
)

class BasicInfoInputViewModel : ContainerHost<BasicInfoInputState, Nothing>, ViewModel() {

    override val container = container<BasicInfoInputState, Nothing>(BasicInfoInputState())

    companion object {
        const val PAGE_FIRST = 0
        const val PAGE_SECOND = 1
    }

}