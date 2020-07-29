package com.devnunu.zipcheck.ui.inputtemplate

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class InputTemplateModule {

    @ContributesAndroidInjector
    abstract fun checkListTemplateFragment(): InputTemplateFragment

    @Binds
    @IntoMap
    @ViewModelKey(InputInputTemplateViewModel::class)
    abstract fun bindViewModel(viewModel: InputInputTemplateViewModel): ViewModel
}