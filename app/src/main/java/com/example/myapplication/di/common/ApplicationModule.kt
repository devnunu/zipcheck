package com.example.myapplication.di.common

import com.example.myapplication.data.house.repo.HouseRepository
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