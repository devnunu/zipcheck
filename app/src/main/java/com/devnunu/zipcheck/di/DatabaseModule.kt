package com.devnunu.zipcheck.di

import android.app.Application
import androidx.room.Room
import com.devnunu.zipcheck.data.template.local.TemplateDao
import com.devnunu.zipcheck.data.template.local.TemplateDatabase
import com.devnunu.zipcheck.data.database.AppDatabase
import com.devnunu.zipcheck.data.house.local.HouseDao
import com.devnunu.zipcheck.data.house.local.HouseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    open fun provideDb(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "zipCheck.db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideTemplateDatabase(
        db: AppDatabase,
        dao: TemplateDao
    ): TemplateDatabase =
        TemplateDatabase(db, dao)

    @Singleton
    @Provides
    fun provideHouseDatabase(
        db: AppDatabase,
        dao: HouseDao
    ): HouseDatabase =
        HouseDatabase(db, dao)
}

