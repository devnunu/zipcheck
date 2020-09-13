package com.devnunu.zipcheck.di.common

import android.content.Context
import com.devnunu.zipcheck.common.ZipCheckApplication
import com.devnunu.zipcheck.di.DatabaseModule
import com.devnunu.zipcheck.di.ViewModelModule
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
        DatabaseModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ZipCheckApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}