package com.devnunu.zipcheck.data.house.local

import androidx.room.RoomDatabase
import javax.inject.Inject

class HouseDatabase @Inject constructor(
    private val database: RoomDatabase,
    private val houseDao: HouseDao
) {

}