package com.devnunu.zipcheck.di

import com.devnunu.zipcheck.api.HouseApi
import com.devnunu.zipcheck.api.UserApi
import org.koin.dsl.module

val apiModule = module {

    single { UserApi(get()) }

    single { HouseApi(get()) }


}