package com.devnunu.zipcheck.ui.inputchecklist

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class InputCheckListModule {

    @ContributesAndroidInjector
    abstract fun inputCheckListFragment(): InputCheckListFragment

    @Binds
    @IntoMap
    @ViewModelKey(InputCheckListViewModel::class)
    abstract fun bindViewModel(viewModel: InputCheckListViewModel): ViewModel
}
