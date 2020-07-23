package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [House::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
        abstract fun housesDao(): HousesDao
}