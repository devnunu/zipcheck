package com.devnunu.zipcheck.common

import android.content.Context
import com.devnunu.zipcheck.di.common.DaggerApplicationComponent
import com.devnunu.zipcheck.koindi.feature.homeDataModule
import com.devnunu.zipcheck.koindi.data.houseDataModule
import com.devnunu.zipcheck.koindi.data.templateDataModule
import com.devnunu.zipcheck.koindi.feature.templateModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ZipCheckApplication : DaggerApplication() {

    companion object {
        @JvmStatic
        lateinit var context: Context
            private set
    }

    init {
        context = this

        koinInitialize()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }

    /** DI init */
    private fun koinInitialize() {
        startKoin {
            androidContext(this@ZipCheckApplication)
            modules(
                houseDataModule,
                templateDataModule,

                // feature
                homeDataModule,
                templateModule

            )
        }
    }
}
