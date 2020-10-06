package com.devnunu.zipcheck.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.devnunu.zipcheck.data.house.model.CheckItem
import com.devnunu.zipcheck.data.house.dao.HouseDao
import com.devnunu.zipcheck.data.house.entity.HouseEntity
import com.devnunu.zipcheck.data.house.model.HouseStructure
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.data.house.model.TransactionType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(
    entities = [
        HouseEntity::class
    ],
    version = 4,
    exportSchema = false
)
@TypeConverters(DatabaseConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun houseDao(): HouseDao
}

class DatabaseConverters {
    @TypeConverter
    fun fromStringToCheckItem(from: String): List<CheckItem> =
        Gson().fromJson(from, object : TypeToken<List<CheckItem>>() {}.type)

    @TypeConverter
    fun fromCheckItemToString(from: List<CheckItem>): String =
        Gson().toJson(from)

    @TypeConverter
    fun fromStringToTransactionType(from: String?): TransactionType? =
        Gson().fromJson(from, object : TypeToken<TransactionType>() {}.type)

    @TypeConverter
    fun fromTransactionTypeToString(from: TransactionType?): String? =
        Gson().toJson(from)

    @TypeConverter
    fun fromStringToHouseType(from: String?): HouseType? =
        Gson().fromJson(from, object : TypeToken<HouseType>() {}.type)

    @TypeConverter
    fun fromHouseTypeToString(from: HouseType?): String? =
        Gson().toJson(from)

    @TypeConverter
    fun fromStringToHouseStructure(from: String?): HouseStructure? =
        Gson().fromJson(from, object : TypeToken<HouseStructure>() {}.type)

    @TypeConverter
    fun fromHouseStructureToString(from: HouseStructure?): String? =
        Gson().toJson(from)

}