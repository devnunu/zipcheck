package com.devnunu.zipcheck.di.common

import android.content.Context
import com.devnunu.zipcheck.common.ZipCheckApplication
import com.devnunu.zipcheck.di.DatabaseModule
import com.devnunu.zipcheck.di.ViewModelModule
import com.devnunu.zipcheck.ui.inputtemplate.InputTemplateModule
import com.devnunu.zipcheck.ui.inputhouse.InputHouseModule
import com.devnunu.zipcheck.ui.inputtemplatename.InputTemplateNameModule
import com.devnunu.zipcheck.ui.splash.SplashModule
import com.devnunu.zipcheck.ui.inputtemplateitem.InputTemplateItemModule
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
        DatabaseModule::class,
        SplashModule::class,
        InputHouseModule::class,
        InputTemplateNameModule::class,
        InputTemplateModule::class,
        InputTemplateItemModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ZipCheckApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}