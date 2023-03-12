package com.devnunu.zipcheck.di

import com.devnunu.zipcheck.ui.basicInfoDone.BasicInfoDoneViewModel
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel
import com.devnunu.zipcheck.ui.tempBasicInfo.TempBasicInfoViewModel
import com.devnunu.zipcheck.ui.home.HomeViewModel
import com.devnunu.zipcheck.ui.tempDone.TempDoneViewModel
import com.devnunu.zipcheck.ui.tempOption.TempOptionViewModel
import com.devnunu.zipcheck.ui.tempSummary.TempSummaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        BasicInfoInputViewModel(get())
    }
    viewModel {
        BasicInfoDoneViewModel(get())
    }
    viewModel {
        TempBasicInfoViewModel(
            houseId = get(),
            houseRepository = get()
        )
    }
    viewModel {
        TempOptionViewModel(
            houseId = get(),
            houseRepository = get()
        )
    }
    viewModel {
        TempSummaryViewModel(
            houseId = get(),
            houseRepository = get()
        )
    }
    viewModel {
        TempDoneViewModel(
            houseId = get(),
            houseRepository = get()
        )
    }
}