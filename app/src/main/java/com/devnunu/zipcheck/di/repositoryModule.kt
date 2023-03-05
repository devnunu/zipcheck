package com.devnunu.zipcheck.di

import com.devnunu.zipcheck.data.repository.HouseRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        HouseRepository()
    }
}