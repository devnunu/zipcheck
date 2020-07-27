package com.devnunu.zipcheck.ui.home

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindViewModel(viewModel: HomeViewModel): ViewModel
}