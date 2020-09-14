package com.devnunu.zipcheck.di.feature

import com.devnunu.zipcheck.ui.inputtemplate.InputTemplateViewModel
import com.devnunu.zipcheck.ui.inputtemplateitem.InputTemplateItemViewModel
import com.devnunu.zipcheck.ui.inputtemplatename.InputTemplateNameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val templateModule = module {
    viewModel { InputTemplateViewModel(get(), get()) }
    viewModel { InputTemplateItemViewModel(get(), get()) }
    viewModel { InputTemplateNameViewModel() }
}