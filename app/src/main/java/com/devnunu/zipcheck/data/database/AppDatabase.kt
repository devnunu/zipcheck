package com.devnunu.zipcheck.data.database

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devnunu.zipcheck.data.checklist.local.ChecklistDao
import com.devnunu.zipcheck.data.database.entity.ChecklistEntity
import com.devnunu.zipcheck.data.database.entity.HouseEntity
import com.devnunu.zipcheck.data.house.local.HouseDao

@Database(
    entities = [
        (ChecklistEntity::class),
        (HouseEntity::class)
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun checklistDao(): ChecklistDao
    abstract fun houseDao(): HouseDao
}