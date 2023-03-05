package com.devnunu.zipcheck.di

import com.devnunu.zipcheck.ui.basicInfoDone.BasicInfoDoneViewModel
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel
import com.devnunu.zipcheck.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        HomeViewModel()
    }
    viewModel {
        BasicInfoInputViewModel()
    }
    viewModel {
        BasicInfoDoneViewModel()
    }
}