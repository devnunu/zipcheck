package com.example.myapplication.ui.inputhouse

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.ViewModelKey
import com.example.myapplication.ui.inputchecklist.InputCheckListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

class InputHouseViewModel: ViewModel() {
}

@Module
abstract class InputHouseViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(InputHouseViewModel::class)
    abstract fun bindMyViewModel(viewModel: InputHouseViewModel): ViewModel
}