package com.devnunu.zipcheck.di

import android.content.Context
import androidx.room.Room
import com.devnunu.zipcheck.data.db.ZipCheckDatabase

fun provideDB(context: Context): ZipCheckDatabase =
    Room.databaseBuilder(context, ZipCheckDatabase::class.java, ZipCheckDatabase.DB_NAME).build()

fun provideHouseDao(database: ZipCheckDatabase) = database.houseDao()