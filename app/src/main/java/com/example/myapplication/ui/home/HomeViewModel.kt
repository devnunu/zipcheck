package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

class HomeViewModel : ViewModel() {

}

@Module
abstract class HomeViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindMyViewModel(viewModel: HomeViewModel): ViewModel
}