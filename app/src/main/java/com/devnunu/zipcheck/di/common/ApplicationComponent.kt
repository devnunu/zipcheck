package com.devnunu.zipcheck.di.common

import android.content.Context
import com.devnunu.zipcheck.common.ZipCheckApplication
import com.devnunu.zipcheck.ui.home.HomeModule
import com.devnunu.zipcheck.di.ViewModelModule
import com.devnunu.zipcheck.ui.inputchecklist.InputCheckListModule
import com.devnunu.zipcheck.ui.inputhouse.InputHouseModule
import com.devnunu.zipcheck.ui.splash.SplashModule
import com.devnunu.zipcheck.ui.template.CheckListTemplateModule
import com.devnunu.zipcheck.ui.template.CheckListTemplateViewModel
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
        InputHouseModule::class,
        InputCheckListModule::class,
        CheckListTemplateModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ZipCheckApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}