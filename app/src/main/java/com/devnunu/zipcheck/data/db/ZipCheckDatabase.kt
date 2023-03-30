package com.devnunu.zipcheck.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devnunu.zipcheck.data.db.converter.HouseBenefitConverter
import com.devnunu.zipcheck.data.db.converter.HouseOptionConverter
import com.devnunu.zipcheck.data.db.converter.StringListConverter
import com.devnunu.zipcheck.data.db.dao.HouseDao
import com.devnunu.zipcheck.data.model.house.House

@Database(
    entities = [House::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(
    HouseBenefitConverter::class,
    HouseOptionConverter::class,
    StringListConverter::class
)
abstract class ZipCheckDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "ZipCheck.db"
    }

    abstract fun houseDao(): HouseDao

}