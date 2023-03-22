package com.devnunu.zipcheck.api

import com.devnunu.zipcheck.data.model.house.House
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await

class HouseApi(
    private val fireStore: FirebaseFirestore,
) {

    suspend fun getAllHouseList(): List<House> =
        fireStore.collection(COLLECTION_HOUSES)
            .get()
            .await()
            .map { it.toObject() }

    companion object {
        const val COLLECTION_HOUSES = "houses"
    }
}