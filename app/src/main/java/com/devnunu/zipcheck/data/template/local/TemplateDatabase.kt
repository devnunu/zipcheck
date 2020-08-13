package com.devnunu.zipcheck.data.template.local

import androidx.room.RoomDatabase
import javax.inject.Inject

class TemplateDatabase @Inject constructor(
    private val database: RoomDatabase,
    private val templateDao: TemplateDao
) {

}

