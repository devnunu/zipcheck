package com.devnunu.zipcheck.ui.inputlistname

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class InputListNameModule {

    @ContributesAndroidInjector
    abstract fun checkListTemplateFragment(): InputListNameFragment

    @Binds
    @IntoMap
    @ViewModelKey(InputListNameViewModel::class)
    abstract fun bindViewModel(viewModel: InputListNameViewModel): ViewModel
}