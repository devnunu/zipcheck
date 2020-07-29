package com.devnunu.zipcheck.ui.housedetail

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HouseDetailModule {

    @ContributesAndroidInjector
    abstract fun houseDetailFragment(): HouseDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(HouseDetailViewModel::class)
    abstract fun bindViewModel(viewModel: HouseDetailViewModel): ViewModel
}
