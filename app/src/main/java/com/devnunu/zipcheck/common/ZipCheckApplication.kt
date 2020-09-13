package com.devnunu.zipcheck.common

import android.app.Application
import android.content.Context
import com.devnunu.zipcheck.koindi.feature.homeDataModule
import com.devnunu.zipcheck.koindi.data.houseDataModule
import com.devnunu.zipcheck.koindi.data.templateDataModule
import com.devnunu.zipcheck.koindi.feature.splashModule
import com.devnunu.zipcheck.koindi.feature.templateModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ZipCheckApplication : Application() {

    companion object {
        @JvmStatic
        lateinit var context: Context
            private set
    }

    init {
        context = this

        koinInitialize()
    }

    /** DI init */
    private fun koinInitialize() {
        startKoin {
            androidContext(this@ZipCheckApplication)
            modules(
                houseDataModule,
                templateDataModule,

                // feature
                splashModule,
                homeDataModule,
                templateModule

            )
        }
    }
}
