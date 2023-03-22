package com.devnunu.zipcheck.common.application

import android.app.Application
import com.devnunu.zipcheck.di.preferenceModule
import com.devnunu.zipcheck.di.repositoryModule
import com.devnunu.zipcheck.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ZipCheckApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@ZipCheckApplication)
            modules(
                uiModule,
                repositoryModule,
                preferenceModule
            )
        }
    }
}