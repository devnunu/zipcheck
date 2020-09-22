package com.devnunu.zipcheck.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.devnunu.zipcheck.data.checklist.dao.ChecklistDao
import com.devnunu.zipcheck.data.checklist.entity.ChecklistEntity
import com.devnunu.zipcheck.data.checklist.model.CheckItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(
    entities = [
        ChecklistEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun checklistDao(): ChecklistDao
}

class DatabaseConverters {
    @TypeConverter
    fun fromStringToCheckItem(from: String): List<CheckItem> =
        Gson().fromJson(from, object : TypeToken<List<CheckItem>>() {}.type)

    @TypeConverter
    fun fromCheckItemToString(from: List<CheckItem>): String =
        Gson().toJson(from)

}