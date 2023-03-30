package com.devnunu.zipcheck.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val apiModule = module {

    single { provideDB(androidApplication()) }
    single { provideHouseDao(get()) }

}