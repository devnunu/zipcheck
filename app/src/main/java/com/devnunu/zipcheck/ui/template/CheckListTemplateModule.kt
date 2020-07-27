package com.devnunu.zipcheck.ui.template

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class CheckListTemplateModule {

    @ContributesAndroidInjector
    abstract fun checkListTemplateFragment(): CheckListTemplateFragment

    @Binds
    @IntoMap
    @ViewModelKey(CheckListTemplateViewModel::class)
    abstract fun bindViewModel(viewModel: CheckListTemplateViewModel): ViewModel
}