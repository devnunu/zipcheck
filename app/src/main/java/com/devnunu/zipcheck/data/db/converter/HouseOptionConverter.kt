package com.devnunu.zipcheck.data.db.converter

import androidx.room.TypeConverter
import com.devnunu.zipcheck.data.model.house.HouseOption
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class HouseOptionConverter {
    @TypeConverter
    fun fromHouseOptionList(target: List<HouseOption>): String? {
        val type = object : TypeToken<List<HouseOption?>?>() {}.type
        return Gson().toJson(target, type)
    }

    @TypeConverter
    fun toHouseOptionList(targetString: String?): List<HouseOption>? {
        if (targetString == null) {
            return null
        }
        val type = object : TypeToken<List<HouseOption?>?>() {}.type
        return Gson().fromJson(targetString, type)
    }
}