package com.example.myapplication.di.common

import android.content.Context
import com.example.myapplication.common.ZipCheckApplication
import com.example.myapplication.ui.home.HomeModule
import com.example.myapplication.di.ViewModelModule
import com.example.myapplication.ui.inputhouse.InputHouseModule
import com.example.myapplication.ui.splash.SplashModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        HomeModule::class,
        SplashModule::class,
        InputHouseModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ZipCheckApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}