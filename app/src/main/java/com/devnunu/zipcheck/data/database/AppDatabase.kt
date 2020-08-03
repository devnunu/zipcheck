package com.devnunu.zipcheck.data.database

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devnunu.zipcheck.data.checklist.local.ChecklistDao
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.house.local.HouseDao
import com.devnunu.zipcheck.data.house.model.House

@Database(
    entities = [
        (Checklist::class),
        (House::class)
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun checklistDao(): ChecklistDao
    abstract fun houseDao(): HouseDao
}