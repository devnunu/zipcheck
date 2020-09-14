package com.devnunu.zipcheck.di.data

import com.devnunu.zipcheck.data.house.repo.HouseRepository
import org.koin.dsl.module

val houseDataModule = module {
    single { HouseRepository() }
}