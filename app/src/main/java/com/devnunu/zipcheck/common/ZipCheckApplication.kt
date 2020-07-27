package com.devnunu.zipcheck.common

import android.content.Context
import com.devnunu.zipcheck.di.common.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ZipCheckApplication : DaggerApplication() {

    companion object {
        @JvmStatic
        lateinit var context: Context
            private set
    }

    init {
        context = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}
