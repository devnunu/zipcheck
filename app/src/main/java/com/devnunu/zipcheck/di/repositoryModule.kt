package com.devnunu.zipcheck.di

import com.devnunu.zipcheck.data.repository.HouseRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module

val repositoryModule = module {
    single { Firebase.firestore }

    single {
        HouseRepository(get())
    }
}