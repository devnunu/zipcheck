package com.devnunu.zipcheck.data.db.converter

import androidx.room.TypeConverter
import com.devnunu.zipcheck.data.model.house.RoomTypeChecklist
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class RoomTypeChecklistConverter {
    @TypeConverter
    fun fromRoomTypeChecklist(target: List<RoomTypeChecklist>): String? {
        val type = object : TypeToken<List<RoomTypeChecklist>?>() {}.type
        return Gson().toJson(target, type)
    }

    @TypeConverter
    fun toRoomTypeChecklist(targetString: String?): List<RoomTypeChecklist>? {
        if (targetString == null) {
            return null
        }
        val type = object : TypeToken<List<RoomTypeChecklist>?>() {}.type
        return Gson().fromJson(targetString, type)
    }
}