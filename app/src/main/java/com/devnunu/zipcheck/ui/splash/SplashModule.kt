package com.devnunu.zipcheck.ui.splash

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SplashModule {

    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindViewModel(viewModel: SplashViewModel): ViewModel
}