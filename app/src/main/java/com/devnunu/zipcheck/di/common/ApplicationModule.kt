package com.devnunu.zipcheck.di.common

import android.content.Context
import androidx.room.Room
import com.devnunu.zipcheck.data.checklist.repo.ChecklistRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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
    ): ChecklistRepository = ChecklistRepository()
}