package com.example.myapplication.ui.inputchecklist

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.ViewModelKey
import com.example.myapplication.ui.housedetail.HouseDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

class InputCheckListViewModel: ViewModel() {
}

@Module
abstract class InputCheckListViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(InputCheckListViewModel::class)
    abstract fun bindMyViewModel(viewModel: InputCheckListViewModel): ViewModel
}