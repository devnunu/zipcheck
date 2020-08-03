package com.devnunu.zipcheck.data.checklist.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devnunu.zipcheck.data.checklist.local.ChecklistDao
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.house.local.HouseDao

@Database(entities = [Checklist::class], version = 1, exportSchema = false)
abstract class ChecklistDatabase(
    private val database: RoomDatabase,
    private val checklistDao: ChecklistDao
) : RoomDatabase() {
    
}

