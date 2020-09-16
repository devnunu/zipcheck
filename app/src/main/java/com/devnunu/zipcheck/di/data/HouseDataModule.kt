package com.devnunu.zipcheck.di.data

import com.devnunu.zipcheck.data.house.DefaultHouseRepository
import com.devnunu.zipcheck.data.house.HouseDataSource
import com.devnunu.zipcheck.data.house.HouseRepository
import com.devnunu.zipcheck.data.house.local.LocalHouseDataSource
import org.koin.dsl.module

val houseDataModule = module {

    single<HouseDataSource> { LocalHouseDataSource() }

    factory<HouseRepository> { DefaultHouseRepository(get()) }

}