package com.devnunu.zipcheck.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devnunu.zipcheck.data.template.local.TemplateDao
import com.devnunu.zipcheck.data.database.entity.TemplateEntity
import com.devnunu.zipcheck.data.database.entity.HouseEntity
import com.devnunu.zipcheck.data.house.local.HouseDao

@Database(
    entities = [
        (TemplateEntity::class),
        (HouseEntity::class)
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun checklistDao(): TemplateDao
    abstract fun houseDao(): HouseDao
}