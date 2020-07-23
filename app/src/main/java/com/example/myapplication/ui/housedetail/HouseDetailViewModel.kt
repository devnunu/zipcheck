package com.example.myapplication.ui.housedetail

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.ViewModelKey
import com.example.myapplication.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

class HouseDetailViewModel: ViewModel() {
}

@Module
abstract class HouseDetailViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HouseDetailViewModel::class)
    abstract fun bindMyViewModel(viewModel: HouseDetailViewModel): ViewModel
}