package com.devnunu.zipcheck.koindi.feature

import com.devnunu.zipcheck.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}