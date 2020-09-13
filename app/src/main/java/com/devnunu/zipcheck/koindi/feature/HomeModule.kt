package com.devnunu.zipcheck.koindi.feature

import com.devnunu.zipcheck.ui.home.HomeViewModel
import com.devnunu.zipcheck.ui.housedetail.HouseDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { HouseDetailViewModel(get()) }
}