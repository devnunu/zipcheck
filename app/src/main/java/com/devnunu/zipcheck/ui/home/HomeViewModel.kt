package com.devnunu.zipcheck.ui.home

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class HomeState(
    val title: String? = "home"
)

class HomeViewModel : ContainerHost<HomeState, Nothing>, ViewModel() {

    override val container = container<HomeState, Nothing>(HomeState())
}