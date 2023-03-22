package com.devnunu.zipcheck.common.preference.core

interface PreferenceManager {

    fun getString(key: String, defaultValue: String?): String?

    fun setString(key: String, value: String?)
}