package com.devnunu.zipcheck.common

import android.content.Context
import com.devnunu.zipcheck.di.common.DaggerApplicationComponent
import com.devnunu.zipcheck.koindi.feature.homeModule
import com.devnunu.zipcheck.koindi.data.houseModule
import com.devnunu.zipcheck.koindi.feature.houseInputModule
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
                houseModule,

                // feature
                homeModule,
                houseInputModule
            )
        }
    }
}
