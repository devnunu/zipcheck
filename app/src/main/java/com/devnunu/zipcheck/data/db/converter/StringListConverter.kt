package com.devnunu.zipcheck.data.db.converter

import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class StringListConverter {
    @TypeConverter
    fun fromRoomTypeChecklist(target: List<String>): String? {
        val type = object : TypeToken<List<String>?>() {}.type
        return Gson().toJson(target, type)
    }

    @TypeConverter
    fun toRoomTypeChecklist(targetString: String?): List<String>? {
        if (targetString == null) {
            return null
        }
        val type = object : TypeToken<List<String>?>() {}.type
        return Gson().fromJson(targetString, type)
    }
}