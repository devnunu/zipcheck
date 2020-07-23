package com.example.myapplication.common

import android.app.Application
import androidx.room.Room
import com.example.myapplication.data.Database

class ZipCheckApplication:Application() {
    init {
        val db = Room.databaseBuilder(
            applicationContext,
            Database::class.java, "database-name"
        ).build()
    }
}