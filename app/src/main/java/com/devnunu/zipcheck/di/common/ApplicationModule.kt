package com.devnunu.zipcheck.di.common

import com.devnunu.zipcheck.data.template.repo.TemplateRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ApplicationModule {

    /** 레포지터리 */
    @Singleton
    @Provides
    @JvmStatic
    fun provideHouseRepository(
    ): HouseRepository = HouseRepository()

    @Singleton
    @Provides
    @JvmStatic
    fun provideChecklistRepository(
    ): TemplateRepository = TemplateRepository()
}