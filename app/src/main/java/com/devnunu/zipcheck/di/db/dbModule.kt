package com.devnunu.zipcheck.di.db

import androidx.room.Room
import com.devnunu.zipcheck.db.AppDatabase
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "zipCheck.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    factory { get<AppDatabase>().houseDao() }

}