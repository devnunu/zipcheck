package com.devnunu.zipcheck.data.db.converter

import androidx.room.TypeConverter
import com.devnunu.zipcheck.data.model.house.HouseBenefit
import com.devnunu.zipcheck.data.model.house.HouseOption
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class HouseBenefitConverter {
    @TypeConverter
    fun fromHouseBenefitList(target: List<HouseBenefit>): String? {
        val type = object : TypeToken<List<HouseBenefit>?>() {}.type
        return Gson().toJson(target, type)
    }

    @TypeConverter
    fun toHouseBenefitList(targetString: String?): List<HouseBenefit>? {
        if (targetString == null) {
            return null
        }
        val type = object : TypeToken<List<HouseBenefit>?>() {}.type
        return Gson().fromJson(targetString, type)
    }
}