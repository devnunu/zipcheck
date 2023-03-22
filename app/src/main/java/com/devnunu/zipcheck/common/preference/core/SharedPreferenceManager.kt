package com.devnunu.zipcheck.common.preference.core

import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferenceManager(
    private val sharedPreferences: SharedPreferences
) : PreferenceManager {

    override fun getString(key: String, defaultValue: String?): String? =
        sharedPreferences.getString(key, defaultValue)

    override fun setString(key: String, value: String?) =
        sharedPreferences.edit { putString(key, value) }
}