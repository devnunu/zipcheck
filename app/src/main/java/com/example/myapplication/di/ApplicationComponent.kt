package com.example.myapplication.di

import android.app.Application
import android.content.Context
import com.example.myapplication.ui.home.HomeViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        HomeViewModelModule::class
    ])
interface ApplicationComponent : AndroidInjector<Application> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}