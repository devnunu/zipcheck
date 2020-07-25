package com.example.myapplication.ui.splash

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.annotation.ViewModelKey
import com.example.myapplication.ui.home.HomeFragment
import com.example.myapplication.ui.home.HomeViewModel
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