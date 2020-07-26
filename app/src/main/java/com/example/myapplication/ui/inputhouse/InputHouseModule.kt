package com.example.myapplication.ui.inputhouse

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class InputHouseModule {

    @ContributesAndroidInjector
    abstract fun inputHouseFragment(): InputHouseFragment

    @Binds
    @IntoMap
    @ViewModelKey(InputHouseViewModel::class)
    abstract fun bindViewModel(viewModel: InputHouseViewModel): ViewModel
}