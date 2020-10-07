package com.devnunu.zipcheck.di.feature

import com.devnunu.zipcheck.ui.home.HomeViewModel
import com.devnunu.zipcheck.ui.housedetail.HouseDetailViewModel
import com.devnunu.zipcheck.ui.houseedit.HouseEditViewModel
import com.devnunu.zipcheck.ui.inputhouse.InputHouseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeDataModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { HouseDetailViewModel(get()) }
    viewModel { HouseEditViewModel(get()) }
    viewModel { InputHouseViewModel(get()) }
}