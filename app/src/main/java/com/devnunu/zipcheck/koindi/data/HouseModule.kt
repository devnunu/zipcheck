package com.devnunu.zipcheck.koindi.data

import com.devnunu.zipcheck.data.house.repo.HouseRepository
import org.koin.dsl.module

val houseModule = module {
    factory { HouseRepository() }
}