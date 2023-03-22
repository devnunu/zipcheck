package com.devnunu.zipcheck.di

import android.app.Activity
import com.devnunu.zipcheck.common.preference.core.PreferenceManager
import com.devnunu.zipcheck.common.preference.core.SharedPreferenceManager
import com.devnunu.zipcheck.common.preference.user.UserPreference
import com.devnunu.zipcheck.common.preference.user.UserPreferenceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferenceModule = module {

    single { androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE) }
    single<PreferenceManager> { SharedPreferenceManager(get()) }

    factory<UserPreference> { UserPreferenceImpl(get()) }
}