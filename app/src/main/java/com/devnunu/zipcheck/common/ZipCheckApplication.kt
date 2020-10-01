package com.devnunu.zipcheck.common

import android.app.Application
import android.content.Context
import com.devnunu.zipcheck.di.feature.homeDataModule
import com.devnunu.zipcheck.di.data.houseDataModule
import com.devnunu.zipcheck.di.db.dbModule
import com.devnunu.zipcheck.di.feature.splashModule
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
                //db
                dbModule,

                // data
                houseDataModule,

                // feature
                splashModule,
                homeDataModule
            )
        }
    }
}
