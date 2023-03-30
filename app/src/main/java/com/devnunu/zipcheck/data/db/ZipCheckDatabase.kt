package com.devnunu.zipcheck.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devnunu.zipcheck.data.db.converter.HouseBenefitConverter
import com.devnunu.zipcheck.data.db.converter.HouseOptionConverter
import com.devnunu.zipcheck.data.db.converter.RoomTypeChecklistConverter
import com.devnunu.zipcheck.data.db.dao.HouseDao
import com.devnunu.zipcheck.data.model.house.House
import com.devnunu.zipcheck.data.model.house.HouseBenefit

@Database(
    entities = [House::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    HouseBenefitConverter::class,
    HouseOptionConverter::class,
    RoomTypeChecklistConverter::class
)
abstract class ZipCheckDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "ZipCheck.db"
    }

    abstract fun houseDao(): HouseDao

}