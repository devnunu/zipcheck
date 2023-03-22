package com.devnunu.zipcheck.common.preference.user

import com.devnunu.zipcheck.common.preference.core.PreferenceManager

interface UserPreference {
    var userId: String?
}

class UserPreferenceImpl(
    private val preferenceManager: PreferenceManager
) : UserPreference {

    override var userId: String?
        get() = preferenceManager.getString(KEY_USER_ID, null)
        set(value) {
            preferenceManager.setString(KEY_USER_ID, value.toString())
        }

    companion object {
        const val KEY_USER_ID = "KEY_USER_ID"
    }
}