package com.devnunu.zipcheck.ui.inputtemplatename

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class InputTemplateNameModule {

    @ContributesAndroidInjector
    abstract fun checkListTemplateFragment(): InputTemplateNameFragment

    @Binds
    @IntoMap
    @ViewModelKey(InputTemplateNameViewModel::class)
    abstract fun bindViewModel(viewModel: InputTemplateNameViewModel): ViewModel
}