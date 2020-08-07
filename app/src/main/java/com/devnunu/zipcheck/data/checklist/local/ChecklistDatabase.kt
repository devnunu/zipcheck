package com.devnunu.zipcheck.data.checklist.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devnunu.zipcheck.data.checklist.model.Checklist
import javax.inject.Inject

class ChecklistDatabase @Inject constructor(
    private val database: RoomDatabase,
    private val checklistDao: ChecklistDao
) {

}

