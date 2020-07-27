package com.devnunu.zipcheck.di.common

import com.devnunu.zipcheck.data.house.repo.HouseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ApplicationModule {
    @Singleton
    @Provides
    @JvmStatic
    fun provideHouseRepository(
    ): HouseRepository = HouseRepository()
}