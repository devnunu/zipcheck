package com.devnunu.zipcheck.koindi.feature

import com.devnunu.zipcheck.ui.inputhouse.InputHouseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val houseInputModule = module {
    viewModel { InputHouseViewModel(get()) }
}