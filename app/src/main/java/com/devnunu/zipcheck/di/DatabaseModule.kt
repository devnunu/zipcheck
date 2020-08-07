package com.devnunu.zipcheck.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devnunu.zipcheck.data.checklist.local.ChecklistDao
import com.devnunu.zipcheck.data.checklist.local.ChecklistDatabase
import com.devnunu.zipcheck.data.database.AppDatabase
import com.devnunu.zipcheck.data.house.local.HouseDao
import com.devnunu.zipcheck.data.house.local.HouseDatabase
import dagger.Binds
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
    fun provideChecklistDatabase(
        db: AppDatabase,
        dao: ChecklistDao
    ): ChecklistDatabase =
        ChecklistDatabase(db, dao)

    @Singleton
    @Provides
    fun provideHouseDatabase(
        db: AppDatabase,
        dao: HouseDao
    ): HouseDatabase =
        HouseDatabase(db, dao)
}

