package com.devnunu.zipcheck.ui.inputtemplateitem

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class InputTemplateItemModule {

    @ContributesAndroidInjector
    abstract fun checkListTemplateFragment(): InputTemplateItemFragment

    @Binds
    @IntoMap
    @ViewModelKey(InputTemplateItemViewModel::class)
    abstract fun bindViewModel(viewModel: InputTemplateItemViewModel): ViewModel
}